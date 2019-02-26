package com.fg.multithreading;

public class DrawTest {
	public static void main(String[] args) {
		//创建账户
		AccountLock acct=new AccountLock("k", 1000);
		//模拟两个线程对同一个账户取钱
		new DrawThread("甲",acct, 800).start();
		new DrawThread("乙",acct, 800).start();
	}
}
