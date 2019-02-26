package com.fg.multithreading;

public class AccountSyn {
	//��װ�˻���ţ��˻�����������Ա����
		private String accountNo;
		private double balance;
		public AccountSyn() {
			// TODO Auto-generated constructor stub
		}
		public AccountSyn(String accpuntNo,double balance) {
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
		//�ṩһ���̰߳�ȫ��draw()���������ȡǮ����
		public synchronized void draw(double drawAmount)
		{
			//�˻�������ȡǮ��Ŀ
			if(balance>=drawAmount) {
				//����
				System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ�!�³���Ʊ:"+drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				//�޸����
				balance-=drawAmount;
				System.out.println("\t���Ϊ:"+balance);
			}else {
				System.out.println(Thread.currentThread().getName()+"ȡǮʧ��!!����");
			}
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
