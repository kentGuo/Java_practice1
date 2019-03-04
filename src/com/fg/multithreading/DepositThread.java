package com.fg.multithreading;

public class DepositThread extends Thread{
	//ģ���û��˻�
	private AccountSyn2 account;
	//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
	private double depositAmount;
	public DepositThread(String name,AccountSyn2 account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	//������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
	@Override
	public  void run() {
		//ģ��ȡǮ���ظ�100��
		for(int i=0;i<100;i++) {
			account.deposit(depositAmount);
		}
	}
}
