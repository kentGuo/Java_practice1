package com.fg.Collection;

import java.util.Stack;

public class VectorTest {
	public static void main(String[] args) {
		Stack<Object> v=new Stack<>();
		//���ν�����Ԫ��"push"��ջ
		v.push("1");
		v.push("2");
		v.push("3");
		//���:[1,2,3]
		System.out.println(v);
		//���ʵ�һ��Ԫ�أ�����������"pop"��ջ�����:3
		System.out.println(v.peek());
		//��Ȼ���:[1,2,3]
		System.out.println(v);
		//"pop"��ջ��һ��Ԫ�أ����:3
		System.out.println(v.pop());
		//���:[1,2]
		System.out.println(v);
	}
}
