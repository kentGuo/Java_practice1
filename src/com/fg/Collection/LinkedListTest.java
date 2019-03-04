package com.fg.Collection;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Object> books=new LinkedList<>();
		//将字符串元素加入队列的尾部
		books.offer("雪中悍刀行");
		//将一个字符串元素加入栈的顶部
		books.push("庆余年");
		//将字符串元素添加到队列的头部(相当于栈的顶部)
		books.offerFirst("间客");
		for(int i=0;i<books.size();i++) {
			System.out.println(books.get(i));
		}
		//访问但不删除栈顶的元素
		System.out.println(books.peekFirst());
		//访问但不删除队列的最后一个元素
		System.out.println(books.peekLast());
		//将栈顶的元素弹出栈
		System.out.println(books.pop());
		//下面输出将看到队列中第一个元素被删除
		System.out.println(books);
		//访问并删除队列的最后一个元素
		System.out.println(books.pollLast());
		//下面输出将看到队列中个只剩下中间一个元素
		//[庆余年]
		System.out.println(books);
	}
}
