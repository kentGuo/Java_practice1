package com.fg.Collection;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {
	public static void main(String[] args) {
		List<Object> fixedList=Arrays.asList("1","2","3");
		//获取fixedList的实现类，将输出Arrays$ArrayList
		System.out.println(fixedList.getClass());
		//便利fixedList的集合元素
		for(int i=0;i<fixedList.size();i++) {
			System.out.println(fixedList.get(i));
		}
		//试图增加，删除元素都会引发UnsupportedOperationException异常
		fixedList.add("4");
		fixedList.remove("4");
	}
}
