package com.fg.multithreading;

class MyThread extends Thread{
	//�ṩָ���߳����Ĺ�����
		public MyThread(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
		//�ṩָ���߳������߳���Ĺ�����
		public MyThread(ThreadGroup group,String name) {
			super(group,name);
		}
		@Override
		public void run() {
			for(int i=0;i<20;i++) {
				System.out.println(getName()+"�̵߳�i����"+i);
			}
		}
}
public class ThreadGroupTest
{
	public static void main(String[] args) {
		//��ȡ���߳����ڵ��߳��飬���������߳�Ĭ�ϵ��߳���
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		System.out.println("�߳��������:"+mainGroup.getName());
		System.out.println("���߳����Ƿ��Ǻ�̨�߳���:"+mainGroup.isDaemon());
		new MyThread("���߳�����߳�").start();
		ThreadGroup tg=new ThreadGroup("���߳���");
		tg.setDaemon(true);
		System.out.println("tg���߳����Ƿ��Ǻ�̨�߳���:"+tg.isDaemon());
		MyThread tt=new MyThread(tg, "tg���̼߳�");
		tt.start();
		new MyThread(tg,"tg����߳���").start();
	}
	
}