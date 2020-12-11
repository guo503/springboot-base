package com.tsyj.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.tsyj.annotation.Data;
import com.tsyj.annotation.NotEmpty;
import com.tsyj.annotation.NotNull;
import com.tsyj.exception.ParaException;
import com.tsyj.thread.ReqThreadLocal;
import com.tsyj.utils.RequestUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

public abstract class AbstractControllerAspect {

	protected static final String NULL_MESSAGE = "Required parameter '%s' is null";

	protected static final String EMPTY_MESSAGE = "Required parameter '%s' is empty";

	protected static final String LENGTH_MESSAGE = "Required parameter '%s' length limit %s,but now is %s";

	/**
	 * 默认排除字段，Page类属性
	 */
	protected static final List<String> DEFAULT_EXCLUDES = Lists.newArrayList( "start", "sort", "sortType", "version", "MAX_ROW");


	public abstract List<String> getPackages();


	/**
	*切点
	 * @param
	 * @author  guos
	 * @date 2019/4/12 16:05
	 * @return
	 **/
	public abstract void pointcut();

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws Exception {
		setIp(joinPoint);
		checkPara(joinPoint);
	}

	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		ReqThreadLocal.removeAll();
	}

	@AfterReturning(value = "pointcut()", returning = "obj")
	public void afterReturning(JoinPoint joinPoint, Object obj) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
		handleReturnValue(joinPoint, obj);
	}

	@AfterThrowing("pointcut()")
	public void afterThrowing(JoinPoint joinPoint) {
		ReqThreadLocal.removeAll();
	}


	/**
	*设置请求IP
	 * @param joinPoint
	 * @author  guos
	 * @date 2019/4/12 16:05
	 * @return
	 **/
	private void setIp(JoinPoint joinPoint) throws NoSuchFieldException, SecurityException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String ip = RequestUtils.getIpAddr(request);
		ReqThreadLocal.setIp(ip);
	}


	/**
	*检查参数
	 * @param joinPoint
	 * @author  guos
	 * @date 2019/4/12 16:05
	 * @return
	 **/
	private void checkPara(JoinPoint joinPoint) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		String[] notEmptyValue = null;
		int[] notEmptyMaxLen = null;
		String[] notNullValue = null;

		if (method.isAnnotationPresent(NotEmpty.class)) {
			NotEmpty notEmpty = method.getAnnotation(NotEmpty.class);
			notEmptyValue = notEmpty.value();
			notEmptyMaxLen = notEmpty.maxLen();
		}

		if (method.isAnnotationPresent(NotNull.class)) {
			NotNull notNull = method.getAnnotation(NotNull.class);
			notNullValue = notNull.value();
		}

		// post,delete,put 请求体
		JSONObject body = null;

		// 被Body注释的参数对象
		Class<?> requestBodyedClazz = getClassByAnnotaion(method, RequestBody.class);
		Object requestBodyedObject = null;
		if (requestBodyedClazz != null) {
			Object[] args = joinPoint.getArgs();
			body = new JSONObject();
			for (Object arg : args) {
				if (arg != null && arg.getClass().equals(requestBodyedClazz)) {
					requestBodyedObject = arg;
					if (requestBodyedObject != null) {
						body.putAll((JSONObject) JSON.toJSON(requestBodyedObject));
					}
					break;
				}
			}
			//
			request.setAttribute("request-body", body);
		}

		// NotNull校验
		if (notNullValue != null) {
			for (int i = 0; i < notNullValue.length; i++) {
				String paraName = notNullValue[i];
				Object paraValue = null;
				// 获取值
				if (requestBodyedObject != null) {
					paraValue = getValueByField(requestBodyedObject, paraName);
				} else {
					paraValue = request.getParameter(paraName);
				}
				if (paraValue == null) {
					throw new ParaException(String.format(NULL_MESSAGE, paraName));
				}
			}
		}

		// NotEmpty校验
		if (notEmptyValue != null) {
			for (int i = 0; i < notEmptyValue.length; i++) {
				String paraName = notEmptyValue[i];
				Object paraValue = null;
				// 获取值
				if (requestBodyedObject != null) {
					paraValue = getValueByField(requestBodyedObject, paraName);
				} else {
					paraValue = request.getParameter(paraName);
				}

				int maxLen = Integer.MAX_VALUE;
				if (notEmptyMaxLen != null && i < notEmptyMaxLen.length) {
					maxLen = notEmptyMaxLen[i];
				}
				checkNotEmpty(paraName, paraValue, maxLen);
			}
		}

	}


	/**
	*处理返回值
	 * @param joinPoint
	 * @param obj
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private void handleReturnValue(JoinPoint joinPoint, Object obj) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
		if (obj == null) {
			return;
		}
		// 只处理Result
		Class<?> clz = Class.forName("com.tsyj.response.Result");
		if (clz != obj.getClass()) {
			return;
		}
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		List<String> include = null;
		List<String> exclude = new ArrayList<>(DEFAULT_EXCLUDES);

		Data dataAnnotation = method.getAnnotation(Data.class);

		if (dataAnnotation != null) {
			if (dataAnnotation.include().length != 0) {
				include = new ArrayList<String>();
				for (String e : dataAnnotation.include()) {
					include.add(e);
				}
			}
			if (dataAnnotation.exclude().length != 0) {
				for (String e : dataAnnotation.exclude()) {
					exclude.add(e);
				}
			}
		}

		Field dataField = clz.getDeclaredField("data");
		dataField.setAccessible(true);
		// 获取data对象
		Object data = dataField.get(obj);
		if (data == null) {
			return;
		}

		handleData(data, include, exclude);
	}


	/**
	*根据include,exclude 处理目标对象
	 * @param targetObject
	 * @param include
	 * @param exclude
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private void handleData(Object targetObject, List<String> include, List<String> exclude)
			throws IllegalArgumentException, IllegalAccessException {
		// 获取data所有成员属性
		if (targetObject == null) {
			return;
		}

		// Collection 类型
		if (targetObject instanceof Collection<?>) {
			Collection<?> collect = (Collection<?>) targetObject;
			for (Object e : collect) {
				handleData(e, include, exclude);
			}
		}

		// Map 类型
		if (targetObject instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) targetObject;
			Collection<?> values = map.values();
			if (values != null) {
				for (Object e : values) {
					handleData(e, include, exclude);
				}
			}
		}

		if (!deducePOVO(targetObject.getClass())) {
			return;
		}

		Set<Field> fieldSet = getDeclaredFields(targetObject.getClass());

		for (Field e : fieldSet) {
			e.setAccessible(true);

			Object obj = e.get(targetObject);

			// Collection 类型
			if (obj instanceof Collection<?>) {
				Collection<?> collect = (Collection<?>) obj;
				for (Object e2 : collect) {
					handleData(e2, include, exclude);
				}
			}

			// Map 类型
			if (obj instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) obj;
				Collection<?> values = map.values();
				if (values != null) {
					for (Object e2 : values) {
						handleData(e2, include, exclude);
					}
				}
			}

			else if (deducePOVO(e.getType())) {
				Object obj2 = e.get(targetObject);
				handleData(obj2, include, exclude);
			}
			// 判断执行include or exclude
			if (include != null && include.size() != 0) {
				if (!include.contains(e.getName()) && !e.getType().isPrimitive() && !Modifier.isFinal(e.getModifiers())) {
					e.set(targetObject, null);
				}
			}

			else {
				if (exclude.contains(e.getName()) && !e.getType().isPrimitive() && !Modifier.isFinal(e.getModifiers())) {
					e.set(targetObject, null);
				}
			}

		}

	}


	/**
	*判断是否非空及长度限制
	 * @param paraName
	 * @param paraValue
	 * @param maxLen
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private void checkNotEmpty(String paraName, Object paraValue, int maxLen) throws Exception {
		if (paraValue == null) {
			throw new ParaException(String.format(EMPTY_MESSAGE, paraName));
		}

		int paraLen = 0;

		if (paraValue instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) paraValue;
			paraLen = collection.size();
		}

		else if (paraValue instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) paraValue;
			paraLen = map.size();
		}

		else if (paraValue.getClass().isArray()) {
			Object[] array = (Object[]) paraValue;
			paraLen = array.length;
		}

		else {
			paraLen = String.valueOf(paraValue).length();
		}

		if (paraLen == 0) {
			throw new ParaException(String.format(EMPTY_MESSAGE, paraName));
		}

		if (paraLen > maxLen) {
			throw new ParaException(String.format(LENGTH_MESSAGE, paraName, maxLen, paraLen));
		}

	}


	/**
	*获取对象某个属性的值
	 * @param object
	 * @param field
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private Object getValueByField(Object object, String field)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		Set<Field> fieldSet = getDeclaredFields(clazz);
		for (Field f : fieldSet) {
			f.setAccessible(true);
			if (f.getName().equals(field)) {
				return f.get(object);
			}
		}
		return null;
	}


	/**
	*获取class所有成员属性
	 * @param clazz
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private Set<Field> getDeclaredFields(Class<?> clazz) {
		Set<Field> fieldSet = new HashSet<>();
		while (clazz != null) {
			fieldSet.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
			clazz = clazz.getSuperclass();
		}
		return fieldSet;
	}


	/**
	*获取被RequestBody注解的方法参数的class
	 * @param method
	 * @param clazz
	 * @author  guos
	 * @date 2019/4/12 16:04
	 * @return
	 **/
	private Class<?> getClassByAnnotaion(Method method, Class<? extends Annotation> clazz) {
		Parameter[] params = method.getParameters();
		for (Parameter e : params) {
			if (e.isAnnotationPresent(clazz)) {
				return e.getType();
			}
		}
		return null;
	}


	/**
	*判断是否po,vo包的类
	 * @param clazz
	 * @author  guos
	 * @date 2019/4/12 16:03
	 * @return
	 **/
	private boolean deducePOVO(Class<?> clazz) {
		if (clazz.getPackage() != null) {
			String packageName = clazz.getPackage().getName();
			if (getPackages().contains(packageName)) {
				return true;
			}
		}
		return false;
	}

}
