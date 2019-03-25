package com.fg.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class AccountLock {
	//定义锁对象
	private final ReentrantLock lock=new ReentrantLock();
	//封装账户编号，账户余额的两个成员变量
		private String accountNo;
		private double balance;
		public AccountLock() {
			// TODO Auto-generated constructor stub
		}
		public AccountLock(String accpuntNo,double balance) {
			this.accountNo=accpuntNo;
			this.balance=balance;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public double getBalance() {
			return balance;
		}
		//提供一个线程安全的draw()方法来完成取钱操作
		public void draw(double drawAmount) {
			//加锁
			lock.lock();
			try {
			//账户余额大于取钱数目
			if(balance>=drawAmount) {
				//出钞
				System.out.println(Thread.currentThread().getName()+"取钱成功!吐出钞票:"+drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				//修改余额
				balance-=drawAmount;
				System.out.println("\t余额为:"+balance);
			}else {
				System.out.println(Thread.currentThread().getName()+"取钱失败!!余额不足");
			}
			}finally {
				lock.unlock();
			}
		}
		//下面两个方法根据accountNo来重写hasCode()和equals()方法
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return accountNo.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(this==obj)return true;
			if(obj!=null&&obj.getClass()==Account.class) {
				Account target=(Account)obj;
				return target.getAccountNo().equals(accountNo);
			}
			return false;
		}
}
