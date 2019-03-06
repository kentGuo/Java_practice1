package com.fg.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread{
	private BlockingQueue<String> bq;

	public Producer(BlockingQueue<String> bq) {
		super();
		this.bq = bq;
	}
	@Override
	public void run() {
		String[] strArr=new String[]
		{
			"Java",
			"Strus",
			"Spring"
		};
		for(int i=0;i<999999;i++) {
			System.out.println(getName()+"������׼����������Ԫ��!");
			try {
				Thread.sleep(200);
				//���Է���Ԫ�أ������������,���̱߳�����
				bq.put(strArr[i%3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName()+"�������"+bq);
		}
	}
}
class Consumer extends Thread{
	private BlockingQueue<String> bq;

	public Consumer(BlockingQueue<String> bq) {
		super();
		this.bq = bq;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println(getName()+"������׼�����Ѽ���Ԫ��!");
			try {
				Thread.sleep(200);
				//����ȡ��Ԫ�أ���������ѿգ����̱߳�����
				bq.take();
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName()+"�������:"+bq);
		}
	}
}
public class BlockingQueueTest2 {
	public static void main(String[] args) {
		//����һ������Ϊ1��BlockingQueue
		BlockingQueue<String> bq=new ArrayBlockingQueue<>(1);
		//����3���������߳�
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		//����һ���������߳�
		new Consumer(bq).start();
	}
}
