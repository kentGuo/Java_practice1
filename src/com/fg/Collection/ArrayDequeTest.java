package com.fg.Collection;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque<String> stack=new ArrayDeque<>();
		//���ν�����Ԫ��push��ջ
		stack.push("ѩ�к�����");
		stack.push("���");
		stack.push("������");
		//���[������, ���, ѩ�к�����]
		System.out.println(stack);
		//���ʵ�һ��Ԫ�أ�����������pop��ջ�����[������]
		System.out.println(stack.peek());
		//���[������, ���, ѩ�к�����]
		System.out.println(stack);
		//pop����һ��Ԫ�أ����:[������]
		System.out.println(stack.pop());
		//���:[���, ѩ�к�����]
		System.out.println(stack);
	}
}
