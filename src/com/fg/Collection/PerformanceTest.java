package com.fg.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PerformanceTest {
	public static void main(String[] args) {
		//����һ���ַ�������
		String[] ts1=new String[900000];
		//��̬��ʼ������Ԫ��
		for(int i=0;i<900000;i++) {
			ts1[i]=String.valueOf(i);
		}
		ArrayList<Object> a1=new ArrayList<>();
		//�����е�����Ԫ�ؼ���ArrayList������
		for(int i=0;i<900000;i++) {
			a1.add(ts1[i]);
		}
		LinkedList<Object> ll=new LinkedList<>();
		//�����е�����Ԫ�ؼ���LinkedList������
		for(int i=0;i<900000;i++) {
			ll.add(ts1[i]);
		}
		//��������ArrayList���ϵ�����Ԫ�أ����������ʱ��
		long start=System.currentTimeMillis();
		for(Iterator<Object> it=a1.iterator();it.hasNext();) {
			it.next();
		}
		System.out.println("����ArrayList����Ԫ�� ��ʱ��:"+(System.currentTimeMillis()-start));
		//��������LinedList���ϵ�����Ԫ�أ����������ʱ��
		start=System.currentTimeMillis();
		for(Iterator<Object> it=ll.iterator();it.hasNext();) {
			it.next();
		}
		System.out.println("����LinedList����Ԫ�ص�ʱ��:"+
		(System.currentTimeMillis()-start));
	}
}
