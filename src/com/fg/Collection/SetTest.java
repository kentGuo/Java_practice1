package com.fg.Collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<Object> books=new HashSet<>();
		//���һ���ַ�������
		books.add(new String("ѩ�к�����"));
		//�ٴ����һ���ַ�������
		//��Ϊ�����ַ�������ͨ��equals�����Ƚ����
		//�������ʧ��,����false
		boolean result=books.add(new String("ѩ�к�����"));
		//�����������������ֻ��һ��Ԫ��
		System.out.println(result+"------->"+books);
	}
}
