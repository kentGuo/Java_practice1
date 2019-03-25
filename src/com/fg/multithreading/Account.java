package com.fg.multithreading;

public class Account {
	//封装账户编号，账户余额的两个成员变量
	private String accountNo;
	private double balance;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String accpuntNo,double balance) {
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
	public void setBalance(double balance) {
		this.balance = balance;
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
