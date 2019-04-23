
package com.tsyj.exception;


import com.tsyj.constant.IErrorCode;
import lombok.Data;



/**
 *业务异常
 * @author: guos
 * @date: 2019/4/12 16:17
 **/
@Data
public class ServiceException extends RuntimeException {

	/**
	 *
	 */
	private final static long serialVersionUID = 5827674159912277791L;

	private IErrorCode errorCode;

	public ServiceException() {

	}

	public ServiceException(String message) {
		super(message);
	}

	public static ServiceException getInstance(String message){
		return new ServiceException(message);
	}

	public static ServiceException getInstance(String message, Object... args){
		for (Object obj : args) {
			message = message.replaceFirst("\\{\\}", String.valueOf(obj));
		}
		return new ServiceException(message);
	}

	public ServiceException(IErrorCode errorCode) {
		super(errorCode.getMessage());
		this.setErrorCode(errorCode);
	}

	public ServiceException(IErrorCode errorCode, String message) {
		super(message);
		this.setErrorCode(errorCode);
	}

}

