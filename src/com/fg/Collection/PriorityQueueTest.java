package com.fg.Collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		//������pq�м����ĸ�Ԫ��
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		pq.offer(3);
		//���pq���У������ǰ�Ԫ�صļ���˳������
		//���ǰ�Ԫ�صĴ�С˳�����У����[-3,3,0,6,9]
		System.out.println(pq);
		//���ʶ��еĵ�һ��Ԫ�أ���ʵ���Ƕ�������С��Ԫ�أ�-3
		System.out.println(pq.poll());
		//�����������μ������ʵ�һ��Ԫ��,�Ѿ������ʹ��ľͲ������
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
