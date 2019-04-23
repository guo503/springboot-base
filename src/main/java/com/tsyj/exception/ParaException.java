package com.tsyj.exception;


/**
 *参数缺省异常
 * @author: guos
 * @date: 2019/4/12 15:51
 **/
public class ParaException extends RuntimeException {

	private final static long serialVersionUID = 1L;

	public ParaException() {

	}

	public ParaException(String message) {
		super(message);
	}

}
