package com.fg.multithreading;

public class DrawTest {
	public static void main(String[] args) {
		//�����˻�
		AccountLock acct=new AccountLock("k", 1000);
		//ģ�������̶߳�ͬһ���˻�ȡǮ
		new DrawThread("��",acct, 800).start();
		new DrawThread("��",acct, 800).start();
	}
}
