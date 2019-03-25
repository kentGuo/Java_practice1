package com.fg.multithreading;

public class StartDead extends Thread{
	private int i;
	//重写run()方法,run()方法的方法体就是线程的执行体
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) throws Exception {
		//创建线程对象
		StartDead sd=new StartDead();
		for(int i=0;i>300;i++) {
			//调用Thread.currentThre().getName()总是获取当前线程的名字
			System.out.println(Thread.currentThread().getName()+""+i);
			if(i==20) {
				//启动线程
				sd.start();
				//判断启动后线程的isAlive()值，输出true
				System.out.println(sd.isAlive());
			}
			/**
			 * 当线程处于新建，死亡两种状态时，isAlive()方法返回false
			 * 当i>20时，该线程肯定已经启动过了，如果sd.isAlive()为false时
			 * 那就是死亡状态了
			 */
			if(i>20&&sd.isAlive()==false) {
				sd.start();
			}
		}
	}
}
