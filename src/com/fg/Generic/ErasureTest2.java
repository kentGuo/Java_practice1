package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

public class ErasureTest2 {
	public static void main(String[] args) {
		List<Integer> li=new ArrayList<>();
		li.add(5);
		li.add(2);
		List list=li;
		//�����������'δ������ת��'���棬���룬����ʱ��ȫ����
		System.out.println(list.get(0));
		List<String> ls=new ArrayList<>();
		ls=list;
		//ֻҪ����ls���Ԫ�أ�������뽫����ClassCastException�쳣
		System.out.println(ls.get(0));
	}
}
