package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

public class ErasureTest2 {
	public static void main(String[] args) {
		List<Integer> li=new ArrayList<>();
		li.add(5);
		li.add(2);
		List list=li;
		//下面代码引起'未经检查的转换'警告，编译，运行时完全正常
		System.out.println(list.get(0));
		List<String> ls=new ArrayList<>();
		ls=list;
		//只要访问ls里的元素，下面代码将引发ClassCastException异常
		System.out.println(ls.get(0));
	}
}
