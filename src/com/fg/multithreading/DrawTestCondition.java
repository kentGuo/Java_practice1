package com.fg.multithreading;

public class DrawTestCondition {
	public static void main(String[] args) {
		AccountCondition account=new AccountCondition("1234567",0);
		new DrawThreadCondition("ȡǮ��", account, 800).start();
		new DepositThreadCondition("��Ǯ�� ��", account, 800).start();
		new DepositThreadCondition("��Ǯ�� ��", account, 800).start();
		new DepositThreadCondition("��Ǯ�� ��", account, 800).start();
	}
}
