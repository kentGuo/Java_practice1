package com.fg.multithreading;

public class DrawThread extends Thread{
	//ģ���û��˻�
	private AccountLock account;
	//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
	private double drawAmount;
	public DrawThread(String name,AccountLock account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	//������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
	@Override
	public  void run() {
		/**
		 * ֱ�ӵ���account�����draw()������ִ��ȡǮ����
		 * ͬ��������ͬ����������this,this�������draw()�����Ķ���
		 * Ҳ����˵���߳̽���draw()����֮ǰ�������ȶ�account�������
		 */
		account.draw(drawAmount);
	}
}
