package com.fg.multithreading;

public class DaemonThread extends Thread{
	//定义后台线程的线程执行体与普通线程没有任何区别
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt=new DaemonThread();
		//将线程设置为后台线程
		dt.setDaemon(true);
		//启动后台线程
		dt.start();
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+""+i);
		}
		//----------程序执行到此处，前台线程(main线程)结束----------------
		//后台线程也应该随之结束
	}
}
