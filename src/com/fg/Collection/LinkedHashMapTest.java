package com.fg.Collection;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<Object, Object> scores=new LinkedHashMap<>();
		scores.put("����", 80);
		scores.put("��ѧ", 82);
		scores.put("Ӣ��", 79);
		scores.put("��ѧ", 90);
		//����scores�������key-value��
		for(Object key:scores.keySet()) {
			System.out.println(key+"------>"+scores.get(key));
		}
	}
}
