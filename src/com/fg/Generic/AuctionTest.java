package com.fg.Generic;

import java.util.Scanner;

public class AuctionTest {
	private double initPrice=30.0;
	//��Ϊ�÷�������ʽ�׳���AuctionException�쳣
	//���Դ˴���Ҫ�����׳�AuctionException�쳣
	public void bid(String bidPrice) throws AuctionException {
		//bidPrice=sc.nextLine();
		double d=0.0;
		try {
			d=Double.parseDouble(bidPrice);
		} catch (Exception e) {
			// TODO: handle exception
			//�˴���ɱ������п��Զ��쳣ִ�е��޸�����
			//�˴��������ڿ���̨��ӡ�쳣�ĸ���ջ��Ϣ
			e.printStackTrace();
			//�ٴ��׳��Զ����쳣
			throw new AuctionException("���ļ۱�������ֵ"+"���ܰ��������ַ���");
		}
		if(initPrice>d){
			throw new AuctionException("���ļ۱����ļ۵ͣ�"+"�������ģ�");
		}
		initPrice=d;
	}
	public static void main(String[] args) {
		AuctionTest at=new AuctionTest();
		@SuppressWarnings("resource")
		String t=new Scanner(System.in).nextLine();
		try {
			at.bid(t);
		} catch (Exception e) {
			// TODO: handle exception
			//�ٴβ���bid()�����е��쳣�����Ը��쳣���д���
			System.out.println(e.getMessage());
		}
	}
}
