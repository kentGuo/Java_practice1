package com.fg.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		//定义一个长度为2的阻塞队列
		BlockingQueue<String> bq=new ArrayBlockingQueue<>(2);
//		bq.put("Java");//与bq.add("Java"),bq.offer("Java")相同
//		bq.put("Java");//与bq.add("Java"),bq.offer("Java")相同
//		bq.put("Java");//阻塞线程
		System.out.println(bq.add("bq"));
		System.out.println(bq.offer("bq"));//返回true
		System.out.println(bq.add("bq"));//抛出异常
		System.out.println(bq.offer("bq"));//返回false
	}
}
