package com.fg.multithreading;

public class Account {
	//��װ�˻���ţ��˻�����������Ա����
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
	//����������������accountNo����дhasCode()��equals()����
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
