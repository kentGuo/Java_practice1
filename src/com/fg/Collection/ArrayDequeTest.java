package com.fg.Collection;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque<String> stack=new ArrayDeque<>();
		//依次将三个元素push入栈
		stack.push("雪中悍刀行");
		stack.push("间客");
		stack.push("庆余年");
		//输出[庆余年, 间客, 雪中悍刀行]
		System.out.println(stack);
		//访问第一个元素，但并不将其pop出栈，输出[庆余年]
		System.out.println(stack.peek());
		//输出[庆余年, 间客, 雪中悍刀行]
		System.out.println(stack);
		//pop出第一个元素，输出:[庆余年]
		System.out.println(stack.pop());
		//输出:[间客, 雪中悍刀行]
		System.out.println(stack);
	}
}
