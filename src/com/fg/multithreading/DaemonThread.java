package com.fg.multithreading;

public class DaemonThread extends Thread{
	//�����̨�̵߳��߳�ִ��������ͨ�߳�û���κ�����
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt=new DaemonThread();
		//���߳�����Ϊ��̨�߳�
		dt.setDaemon(true);
		//������̨�߳�
		dt.start();
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+""+i);
		}
		//----------����ִ�е��˴���ǰ̨�߳�(main�߳�)����----------------
		//��̨�߳�ҲӦ����֮����
	}
}
