package com.fg.multithreading;

public class DrawTestSyn {
	public static void main(String[] args) {
		AccountSyn2 account=new AccountSyn2("1234567",0);
		new DrawThreadSyn2("取钱者", account, 800).start();
		new DepositThread("存钱者 甲", account, 800).start();
		new DepositThread("存钱者 乙", account, 800).start();
		new DepositThread("存钱者 丙", account, 800).start();
	}
}
