package com.fg.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		//����һ������Ϊ2����������
		BlockingQueue<String> bq=new ArrayBlockingQueue<>(2);
//		bq.put("Java");//��bq.add("Java"),bq.offer("Java")��ͬ
//		bq.put("Java");//��bq.add("Java"),bq.offer("Java")��ͬ
//		bq.put("Java");//�����߳�
		System.out.println(bq.add("bq"));
		System.out.println(bq.offer("bq"));//����true
		System.out.println(bq.add("bq"));//�׳��쳣
		System.out.println(bq.offer("bq"));//����false
	}
}
