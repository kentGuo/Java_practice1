package com.fg.Generic;

public class AuctionException extends Exception{
	/**
	 * from KentG
	 */
	private static final long serialVersionUID = 1L;
	//无参数构造器
	public AuctionException(){}
	//带一个字符串参数的构造器
	public AuctionException(String msg) {
		super(msg);
	}
}
