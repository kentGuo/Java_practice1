package com.fg.multithreading;

public class DepositThreadCondition extends Thread{
	//模拟用户账户
		private AccountCondition account;
		//当前取钱线程所希望取的钱数
		private double depositAmount;
		public DepositThreadCondition(String name,AccountCondition account, double depositAmount) {
			super(name);
			this.account = account;
			this.depositAmount = depositAmount;
		}
		//当多个线程修改同一个共享数据时，将涉及数据安全问题
		@Override
		public  void run() {
			//模拟取钱，重复100次
			for(int i=0;i<100;i++) {
				account.deposit(depositAmount);
			}
		}
}
