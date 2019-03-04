package com.fg.multithreading;

public class AccountSyn2{
	//封装账户编号，账户余额的两个成员变量
	private String accountNo;
	private double balance;
	//标识账户中是否已有存款的旗标
	private boolean flag=false;
	
	public AccountSyn2() {
		// TODO Auto-generated constructor stub
	}
	public AccountSyn2(String accpuntNo,double balance) {
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
		return this.balance;
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
	public synchronized void draw(double drawAmount) {
		try {
			//如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if(!flag)
			{
				wait();
			}else {
				//执行取钱操作
				System.out.println(Thread.currentThread().getName()+" 取钱:"+drawAmount);
				balance-=drawAmount;
				System.out.println("账户余额为:"+balance);
				//标识账户是否已有存款的旗标设为false
				flag=false;
				//唤醒其他线程
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount) {
		try {
			//如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if(flag)
			{
				wait();
			}else {
				//执行取钱操作
				System.out.println(Thread.currentThread().getName()+" 存钱:"+depositAmount);
				balance+=depositAmount;
				System.out.println("账户余额为:"+balance);
				//标识账户是否已有存款的旗标设为false
				flag=true;
				//唤醒其他线程
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

