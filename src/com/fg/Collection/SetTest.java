package com.fg.Collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<Object> books=new HashSet<>();
		//添加一个字符串对象
		books.add(new String("雪中悍刀行"));
		//再次添加一个字符串对象
		//因为两个字符串对象通过equals方法比较相等
		//所以添加失败,返回false
		boolean result=books.add(new String("雪中悍刀行"));
		//从下面输出看到集合只有一个元素
		System.out.println(result+"------->"+books);
	}
}
