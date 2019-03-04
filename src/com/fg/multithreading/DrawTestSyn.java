package com.fg.multithreading;

public class DrawTestSyn {
	public static void main(String[] args) {
		AccountSyn2 account=new AccountSyn2("1234567",0);
		new DrawThreadSyn2("È¡Ç®Õß", account, 800).start();
		new DepositThread("´æÇ®Õß ¼×", account, 800).start();
		new DepositThread("´æÇ®Õß ÒÒ", account, 800).start();
		new DepositThread("´æÇ®Õß ±û", account, 800).start();
	}
}
