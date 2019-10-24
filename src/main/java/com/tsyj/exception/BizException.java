
package com.tsyj.exception;
import com.tsyj.consts.IErrorCode;
import lombok.Data;

/**
 *业务异常
 * @author: guos
 * @date: 2019/4/12 16:17
 **/
@Data
public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private final static long serialVersionUID = 5827674159912277791L;

	private IErrorCode errorCode;

	public BizException() {

	}

	public BizException(String message) {
		super(message);
	}
	
	public static BizException getInstance(String message){
		return new BizException(message);
	}
	
	public static BizException getInstance(String message,  Object... args){
		for (Object obj : args) {
			message = message.replaceFirst("\\{\\}", String.valueOf(obj));
		}
		return new BizException(message);
	}

	public BizException(IErrorCode errorCode) {
		super(errorCode.getMessage());
		this.setErrorCode(errorCode);
	}
	
	public BizException(IErrorCode errorCode, String message) {
		super(message);
		this.setErrorCode(errorCode);
	}

}

