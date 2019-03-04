package com.fg.Collection;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<Object, Object> scores=new LinkedHashMap<>();
		scores.put("语文", 80);
		scores.put("数学", 82);
		scores.put("英语", 79);
		scores.put("化学", 90);
		//遍历scores里的所有key-value对
		for(Object key:scores.keySet()) {
			System.out.println(key+"------>"+scores.get(key));
		}
	}
}
