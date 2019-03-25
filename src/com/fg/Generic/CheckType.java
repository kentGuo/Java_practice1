package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

//自定义一个StrList集合类，使用组合的方式来复用ArrayList类
class StrList{
	private List<Object> strList=new ArrayList<>();
	//定义strList的add方法
	public boolean add(String ele) {
		return strList.add(ele);
	}
	//重写get()方法，将get()方法的返回值类型改为String类型
	public String get(int index) {
		return (String)strList.get(index);
	}
	public int size() {
		return strList.size();
	}
}
public class CheckType {
	public static void main(String[] args) {
		//创建一个只想保存字符串的List集合
		StrList strList=new StrList();
		strList.add("庆余年");
		strList.add("天骄无双");
		strList.add("步步生莲");
		//下面渔具不能把Integer对象丢进集合中，否则将引起编译错误
		//strList.add(5);
		System.out.println(strList);
		for(int i=0;i<strList.size();i++) {
			//因为StrList里元素的类型就是String类型
			//所以无需进行强制类型转换
			String str=strList.get(i);
			System.out.println(str+"\n");
		}
	}
}
