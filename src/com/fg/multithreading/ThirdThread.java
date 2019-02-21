package com.fg.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread{
	public static void main(String[] args) {
		//����Callable����
		ThirdThread rt=new ThirdThread();
		//��ʹ��Lambda����ʽ����Callable<Integer>����
		//��ʹ��FutureTask����װCallable����
		FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
			int i=0;
			for(;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+" ��ѭ������i��ֵ:"+i);
			}
			//call()���������з���ֵ
			return i;
		});
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+""+i);
			if(i==20) {
				//ʵ�ʻ�����Callable�����������������߳�
				new Thread(task,"�з���ֵ���߳�").start();
			}
		}
		try {
			//��ȡ����ֵ
			System.out.println("���̵߳ķ���ֵ:"+task.get());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}