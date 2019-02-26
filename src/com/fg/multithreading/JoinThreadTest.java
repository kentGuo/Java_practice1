package com.fg.multithreading;

public class JoinThreadTest extends Thread{
	//提供一个有参数的构造器，便于设置线程名字
	public JoinThreadTest(String t) {
		super(t);
	}
	//重写run()方法，定义线程执行体
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		//启动子线程
		new JoinThreadTest("新线程").start();
		for(int i=0;i<100;i++) {
			if(i==20) {
				JoinThreadTest jt=new JoinThreadTest("被join的线程");
				jt.start();
				//main线程调用了jt线程 的join()方法，main线程
				//必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()+""+i);
		}
	}
}
