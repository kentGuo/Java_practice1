package com.fg.multithreading;

public class DrawThreadCondition extends Thread{
	//ģ���û��˻�
	private AccountCondition account;
	//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
	private double drawAmount;
	public DrawThreadCondition(String name,AccountCondition account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	//������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
	@Override
	public  void run() {
		//ģ��ȡǮ���ظ�100��
		for(int i=0;i<100;i++) {
			account.draw(drawAmount);
		}
	}
}
