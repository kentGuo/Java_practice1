package com.fg.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightTest {
	//����һ�����ͷ������÷��ͷ����д�һ��T�β�
	static <T> void test(Collection<? extends T> from,Collection<T> to) {
		for(T t:from) {
			to.add(t);
		}
	}
	public static void main(String[] args) {
		List<Object> ao=new ArrayList<>();
		List<String> as=new ArrayList<>();
		//���������ȫ����
		test(as, ao);
	}
}
