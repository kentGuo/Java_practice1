package com.fg.Collection;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args) {
		IdentityHashMap<Object, Object> ihm=new IdentityHashMap<>();
		//�������д��뽫��IdentityHashMap�������������key-value��
		ihm.put(new String("����"), 89);
		ihm.put(new String("����"), 78);
		//�������д��뽫��IdentityHashMap���������һ��key-value��
		ihm.put("java", 93);
		ihm.put("java", 98);
		System.out.println(ihm);
	}
}
