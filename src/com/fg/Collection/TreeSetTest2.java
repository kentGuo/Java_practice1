package com.fg.Collection;

import java.util.TreeSet;

class Z implements Comparable<Object>{

	//��дcompareTo(Object o)���������Ƿ���������
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 1;
	}
	int age;
	public Z(int age) {
		this.age=age;
	}
	//��дequals()���������Ƿ���true
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	}
public class TreeSetTest2 {
	public static void main(String[] args) {
		TreeSet<Object> set=new TreeSet<>();
		Z z1=new Z(6);
		set.add(z1);
		//���true��������ӳɹ�
		System.out.println(set.add(z1));
		//�������set���ϣ�������������Ԫ��
		System.out.println(set);
		//�޸�set���ϵĵ�һ��Ԫ�ص�age����
		((Z)(set.first())).age=9;
		//���set���ϵ����һ��Ԫ�ص�age������������Ҳ�����9
		System.out.println(((Z)(set.last())).age);
	}
}
