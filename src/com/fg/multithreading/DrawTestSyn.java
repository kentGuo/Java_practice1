package com.fg.multithreading;

public class DrawTestSyn {
	public static void main(String[] args) {
		AccountSyn2 account=new AccountSyn2("1234567",0);
		new DrawThreadSyn2("ȡǮ��", account, 800).start();
		new DepositThread("��Ǯ�� ��", account, 800).start();
		new DepositThread("��Ǯ�� ��", account, 800).start();
		new DepositThread("��Ǯ�� ��", account, 800).start();
	}
}
