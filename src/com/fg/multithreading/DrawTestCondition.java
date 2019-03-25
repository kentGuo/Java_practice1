package com.fg.multithreading;

public class DrawTestCondition {
	public static void main(String[] args) {
		AccountCondition account=new AccountCondition("1234567",0);
		new DrawThreadCondition("取钱者", account, 800).start();
		new DepositThreadCondition("存钱者 甲", account, 800).start();
		new DepositThreadCondition("存钱者 乙", account, 800).start();
		new DepositThreadCondition("存钱者 丙", account, 800).start();
	}
}
