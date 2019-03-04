package com.fg.multithreading;

public class DrawTestCondition {
	public static void main(String[] args) {
		AccountCondition account=new AccountCondition("1234567",0);
		new DrawThreadCondition("È¡Ç®Õß", account, 800).start();
		new DepositThreadCondition("´æÇ®Õß ¼×", account, 800).start();
		new DepositThreadCondition("´æÇ®Õß ÒÒ", account, 800).start();
		new DepositThreadCondition("´æÇ®Õß ±û", account, 800).start();
	}
}
