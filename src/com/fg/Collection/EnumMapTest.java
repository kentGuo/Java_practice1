package com.fg.Collection;

import java.util.EnumMap;

enum Season1{
	SPRING,SUMMER,FALL,WINTER
}
public class EnumMapTest {
	public static void main(String[] args) {
		//����һ��EnumMap���󣬸�EnumMap ������key������Seasonö�����ö��ֵ
		EnumMap<Season1, String> enumMap=new EnumMap<Season1, String>(Season1.class);
		enumMap.put(Season1.SUMMER, "��������");
		enumMap.put(Season1.SPRING, "��ů����");
		System.out.println(enumMap);
	}
}
