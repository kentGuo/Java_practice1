package com.fg.Generic;

public class AuctionException extends Exception{
	/**
	 * from KentG
	 */
	private static final long serialVersionUID = 1L;
	//�޲���������
	public AuctionException(){}
	//��һ���ַ��������Ĺ�����
	public AuctionException(String msg) {
		super(msg);
	}
}
