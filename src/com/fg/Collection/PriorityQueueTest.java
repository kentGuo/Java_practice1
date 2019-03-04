package com.fg.Collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		//依次想pq中加入四个元素
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		pq.offer(3);
		//输出pq队列，并不是按元素的加入顺序排列
		//而是按元素的大小顺序排列，输出[-3,3,0,6,9]
		System.out.println(pq);
		//访问队列的第一个元素，其实就是队列中最小的元素：-3
		System.out.println(pq.poll());
		//下面三个依次继续访问第一个元素,已经被访问过的就不再输出
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
