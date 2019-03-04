package com.fg.Collection;

import java.util.EnumMap;

enum Season1{
	SPRING,SUMMER,FALL,WINTER
}
public class EnumMapTest {
	public static void main(String[] args) {
		//创建一个EnumMap对象，该EnumMap 的所有key必须是Season枚举类的枚举值
		EnumMap<Season1, String> enumMap=new EnumMap<Season1, String>(Season1.class);
		enumMap.put(Season1.SUMMER, "夏日炎炎");
		enumMap.put(Season1.SPRING, "春暖花开");
		System.out.println(enumMap);
	}
}
