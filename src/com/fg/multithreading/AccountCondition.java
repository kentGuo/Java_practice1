package com.fg.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AccountCondition {
	// ����������
	private final ReentrantLock lock = new ReentrantLock();
	// ���ָ��Lock�����Ӧ��Condition
	private final Condition cond = lock.newCondition();
	// ��װ�˻���ţ��˻�����������Ա����
	private String accountNo;
	private double balance;
	// ��ʶ�˻����Ƿ����д������
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

	// �ṩһ���̰߳�ȫ��draw()���������ȡǮ����
	public void draw(double drawAmount) {
		// ����
		lock.lock();
		try {
			// ���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ��ȡǮ��������
			if (!flag) {
				cond.await();
			} else {
				// ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName() + " ȡǮ:" + drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ:" + balance);
				// ����ʶ�˻��Ƿ����д��������Ϊfalse
				flag = false;
				// ���������߳�
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ͷ���
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		// ����
		lock.lock();
		try {
			// ���flagΪ�棬�����˻��������˴�Ǯ��ȥ����Ǯ��������
			if (flag) {
				cond.await();
			} else {
				// ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName() + " ��Ǯ:" + depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ:" + balance);
				// ����ʶ�˻��Ƿ����д��������Ϊtrue
				flag = true;
				// ���������߳�
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// �ͷ���
			lock.unlock();
		}
	}

	// ����������������accountNo����дhasCode()��equals()����
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
