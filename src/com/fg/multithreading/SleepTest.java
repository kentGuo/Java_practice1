package com.fg.multithreading;

import java.util.Date;

public class SleepTest{
	public static void main(String[] args) throws Exception{
		for(int i=0;i<10;i++) {
			System.out.println("��ǰʱ��:"+new Date());
			//����sleep()�����õ�ǰ�߳�˯��һ����
			Thread.sleep(1000);
		}
	}
}
