package com.fg.multithreading;

public class DrawThreadSyn extends Thread{
		//ģ���û��˻�
		private Account account;
		//��ǰȡǮ�߳���ϣ��ȡ��Ǯ��
		private double drawAmount;
		public DrawThreadSyn(String name,Account account, double drawAmount) {
			super(name);
			this.account = account;
			this.drawAmount = drawAmount;
		}
		//������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
		@Override
		public  void run() {
			/**
			 * ʹ��account��Ϊͬ�����������κ��߳̽�������ͬ������֮ǰ
			 * �����Ȼ�ö�account�˻�������--�����߳��޷��������Ҳ���޷��޸���
			 * ������������:"����-�޸�-�ͷ���"���߼�
			 */
			synchronized (account) {
				// �˻�������ȡǮ��Ŀ
				if(account.getBalance()>=drawAmount) {
					//�³���Ʊ
					System.out.println(getName()+"ȡǮ�ɹ�!һ��:"+drawAmount+"Ԫ");
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//�޸����
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("\t���Ϊ:"+account.getBalance());
				}else {
					System.out.println(getName()+"ȡǮʧ�ܣ�����!");
				}
			}
			//ͬ��������������߳��ͷ�ͬ����
		}
	}
