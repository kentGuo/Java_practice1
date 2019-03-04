package com.fg.multithreading;

public class AccountSyn2{
	//��װ�˻���ţ��˻�����������Ա����
	private String accountNo;
	private double balance;
	//��ʶ�˻����Ƿ����д������
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
	public synchronized void draw(double drawAmount) {
		try {
			//���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ��ȡǮ��������
			if(!flag)
			{
				wait();
			}else {
				//ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName()+" ȡǮ:"+drawAmount);
				balance-=drawAmount;
				System.out.println("�˻����Ϊ:"+balance);
				//��ʶ�˻��Ƿ����д��������Ϊfalse
				flag=false;
				//���������߳�
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount) {
		try {
			//���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ��ȡǮ��������
			if(flag)
			{
				wait();
			}else {
				//ִ��ȡǮ����
				System.out.println(Thread.currentThread().getName()+" ��Ǯ:"+depositAmount);
				balance+=depositAmount;
				System.out.println("�˻����Ϊ:"+balance);
				//��ʶ�˻��Ƿ����д��������Ϊfalse
				flag=true;
				//���������߳�
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

