package com.fg.multithreading;

public class StartDead extends Thread{
	private int i;
	//��дrun()����,run()�����ķ���������̵߳�ִ����
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(getName()+""+i);
		}
	}
	public static void main(String[] args) throws Exception {
		//�����̶߳���
		StartDead sd=new StartDead();
		for(int i=0;i>300;i++) {
			//����Thread.currentThre().getName()���ǻ�ȡ��ǰ�̵߳�����
			System.out.println(Thread.currentThread().getName()+""+i);
			if(i==20) {
				//�����߳�
				sd.start();
				//�ж��������̵߳�isAlive()ֵ�����true
				System.out.println(sd.isAlive());
			}
			/**
			 * ���̴߳����½�����������״̬ʱ��isAlive()��������false
			 * ��i>20ʱ�����߳̿϶��Ѿ��������ˣ����sd.isAlive()Ϊfalseʱ
			 * �Ǿ�������״̬��
			 */
			if(i>20&&sd.isAlive()==false) {
				sd.start();
			}
		}
	}
}
