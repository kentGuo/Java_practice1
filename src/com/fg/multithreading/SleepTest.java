package com.fg.multithreading;

import java.util.Date;

public class SleepTest{
	public static void main(String[] args) throws Exception{
		for(int i=0;i<10;i++) {
			System.out.println("当前时间:"+new Date());
			//调用sleep()方法让当前线程睡眠一秒钟
			Thread.sleep(1000);
		}
	}
}
