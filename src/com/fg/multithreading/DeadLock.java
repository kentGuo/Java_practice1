package com.fg.multithreading;
/**
 * �߳�����
 * @author Administrator
 *
 */
public class DeadLock implements Runnable{
	A a=new A();
	B b=new B();
	public void init() {
		Thread.currentThread().setName("���߳�");
		//����a�����foo()����
		a.foo(b);
		System.out.println("���������߳�֮��");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("���߳�");
		//����b�����bar()����
		b.bar(a);
		System.out.println("���븱�߳�֮��");
	}
	public static void main(String[] args) {
		DeadLock dl=new DeadLock();
		//��dlΪtarget�������߳�
		new Thread(dl).start();
		//����init()����
		dl.init();
	}

}
class A{
	public synchronized void foo(B b) {
		System.out.println("��ǰ�߳���:"+Thread.currentThread().getName()+" ������Aʵ����foo()����");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("��ǰ�߳���:"+Thread.currentThread().getName()+" ��ͼ����Bʵ����last()����");
		b.last();
	}
	public synchronized void last() {
		System.out.println("������A���last()�������ڲ�");
	}
}
class B{
	public synchronized void bar(A a) {
		System.out.println("��ǰ�߳���:"+Thread.currentThread().getName()+" ������Bʵ����bar()����");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("��ǰ�߳���:"+Thread.currentThread().getName()+" ��ͼ����Bʵ����last()����");
		a.last();
	}
	public synchronized void last() {
		System.out.println("������B���last()�������ڲ�");
	}
}
