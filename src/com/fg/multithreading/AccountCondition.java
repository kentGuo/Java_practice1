package com.fg.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AccountCondition {
	// 定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	// 获得指定Lock对象对应的Condition
	private final Condition cond = lock.newCondition();
	// 封装账户编号，账户余额的两个成员变量
	private String accountNo;
	private double balance;
	// 标识账户中是否已有存款的旗标
	private boolean flag = false;

	public AccountCondition() {
		// TODO Auto-generated constructor stub
	}

	public AccountCondition(String accpuntNo, double balance) {
		this.accountNo = accpuntNo;
		this.balance = balance;
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

	// 提供一个线程安全的draw()方法来完成取钱操作
	public void draw(double drawAmount) {
		// 加锁
		lock.lock();
		try {
			// 如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if (!flag) {
				cond.await();
			} else {
				// 执行取钱操作
				System.out.println(Thread.currentThread().getName() + " 取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为:" + balance);
				// 将标识账户是否已有存款的旗标设为false
				flag = false;
				// 唤醒其他线程
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		// 加锁
		lock.lock();
		try {
			// 如果flag为真，表明账户中已有人存钱进去，存钱方法阻塞
			if (flag) {
				cond.await();
			} else {
				// 执行取钱操作
				System.out.println(Thread.currentThread().getName() + " 存钱:" + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为:" + balance);
				// 将标识账户是否已有存款的旗标设为true
				flag = true;
				// 唤醒其他线程
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}
	}

	// 下面两个方法根据accountNo来重写hasCode()和equals()方法
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}
