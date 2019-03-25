package com.fg.Collection;

import java.util.Stack;

public class VectorTest {
	public static void main(String[] args) {
		Stack<Object> v=new Stack<>();
		//依次将三个元素"push"入栈
		v.push("1");
		v.push("2");
		v.push("3");
		//输出:[1,2,3]
		System.out.println(v);
		//访问第一个元素，但并不将其"pop"出栈，输出:3
		System.out.println(v.peek());
		//依然输出:[1,2,3]
		System.out.println(v);
		//"pop"出栈第一个元素，输出:3
		System.out.println(v.pop());
		//输出:[1,2]
		System.out.println(v);
	}
}
