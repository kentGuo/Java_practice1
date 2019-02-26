package com.fg.multithreading;

public class PriorityTest extends Thread{
	//����һ���в����Ĺ����������������߳�����
	public PriorityTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(getName()+",�����ȼ���:"+getPriority()+",ѭ��������ֵΪ:"+i);
		}
	}
	public static void main(String[] args) {
		//�ı����̵߳����ȼ�
		Thread.currentThread().setPriority(6);
		for(int i=0;i<30;i++) {
			if(i==10) {
				PriorityTest low=new PriorityTest("�ͼ�");
				low.start();
				System.out.println("����֮�������ȼ�:"+low.getPriority());
				//���ø��̵߳�������ȼ�
				low.setPriority(MIN_PRIORITY);
			}
			if(i==20) {
				PriorityTest high=new PriorityTest("�߼�");
				high.start();
				System.out.println("����֮�������ȼ�"+high.getPriority());
				//���ø��̵߳�������ȼ�
				high.setPriority(MAX_PRIORITY);
			}
		}
	}
}
