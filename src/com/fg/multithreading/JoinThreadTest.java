package com.fg.multithreading;

public class JoinThreadTest extends Thread{
	//�ṩһ���в����Ĺ����������������߳�����
	public JoinThreadTest(String t) {
		super(t);
	}
	//��дrun()�����������߳�ִ����
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		//�������߳�
		new JoinThreadTest("���߳�").start();
		for(int i=0;i<100;i++) {
			if(i==20) {
				JoinThreadTest jt=new JoinThreadTest("��join���߳�");
				jt.start();
				//main�̵߳�����jt�߳� ��join()������main�߳�
				//�����jtִ�н����Ż�����ִ��
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()+""+i);
		}
	}
}
