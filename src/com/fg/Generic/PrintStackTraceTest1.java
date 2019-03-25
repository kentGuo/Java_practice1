package com.fg.Generic;

public class PrintStackTraceTest1 {
	public static void main(String[] args) {
		firstMethod();
	}
	public static void firstMethod() {
		seconedMethod();
	}

	public static void seconedMethod() {
			thirdMethod();
	}

	public static void thirdMethod() {
		throw new SefeException("自定义异常信息");
	}
}

class SefeException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	SefeException() {
	}

	SefeException(String msg) {
		super(msg);
	}
}
