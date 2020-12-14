package com.tsyj.utils;

import com.google.common.collect.Lists;
import com.tsyj.model.User;
import org.springframework.util.CollectionUtils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:比较对象属性
 * @Author: guos
 * @Date: create in 2018-03-07 9:11
 */
public class ContractObjUtils {


    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("gs");
        u1.setPhone("111111");
        User u2 = new User();
        u2.setName("gs");
        u2.setPhone("111111");
        System.out.println(compareObject(u1,u2,null));
    }



    /**
     * 比较两个实体属性值，返回一个boolean,true则表时两个对象中的属性值无差异
     *
     * @param oldObject 进行属性比较的对象1
     * @param newObject 进行属性比较的对象2
     * @param fields 需要比较的属性列表，空比较所有属性
     * @return 属性差异比较结果boolean
     */
    public static boolean compareObject(Object oldObject, Object newObject, List<String> fields) {
        Map<String, Map<String, Object>> resultMap = compareFields(oldObject, newObject, fields);
        return resultMap.size() <= 0;
    }

    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个Map分别存oldObject,newObject此属性名的值
     * @param oldObject 进行属性比较的对象1
     * @param newObject 进行属性比较的对象2
     * @param fields 需要比较的属性列表，空比较所有属性
     * @return 属性差异比较结果map
     */
    public static Map<String, Map<String, Object>> compareFields(Object oldObject, Object newObject, List<String> fields) {
        Map<String, Map<String, Object>> map = null;
        try {
            if (oldObject.getClass() == newObject.getClass()) {
                map = new HashMap<>();
                Class<?> clazz = oldObject.getClass();
                //获取object的所有属性
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
                List<PropertyDescriptor> propertyDescriptorList = Lists.newArrayList(pds);
                //比较指定属性
                if (!CollectionUtils.isEmpty(fields)) {
                    propertyDescriptorList = propertyDescriptorList.stream().filter(p -> fields.contains(p.getName())).collect(Collectors.toList());
                }
                for (PropertyDescriptor pd : propertyDescriptorList) {
                    //遍历获取属性名
                    String name = pd.getName();
                    //获取属性的get方法
                    Method readMethod = pd.getReadMethod();
                    // 在oldObject上调用get方法等同于获得oldObject的属性值
                    Object oldValue = readMethod.invoke(oldObject);
                    // 在newObject上调用get方法等同于获得newObject的属性值
                    Object newValue = readMethod.invoke(newObject);

                    if (oldValue instanceof List) {
                        continue;
                    }
                    if (newValue instanceof List) {
                        continue;
                    }
                    if (oldValue instanceof Timestamp) {
                        oldValue = new Date(((Timestamp) oldValue).getTime());
                    }
                    if (newValue instanceof Timestamp) {
                        newValue = new Date(((Timestamp) newValue).getTime());
                    }
                    if (oldValue == null && newValue == null) {
                        continue;
                    }
                    if (oldValue == null) {
                        Map<String, Object> valueMap = new HashMap<String, Object>();
                        valueMap.put("oldValue", null);
                        valueMap.put("newValue", newValue);
                        map.put(name, valueMap);
                        continue;
                    }
                    if (!oldValue.equals(newValue)) {// 比较这两个值是否相等,不等就可以放入map了
                        Map<String, Object> valueMap = new HashMap<String, Object>();
                        valueMap.put("oldValue", oldValue);
                        valueMap.put("newValue", newValue);
                        map.put(name, valueMap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
