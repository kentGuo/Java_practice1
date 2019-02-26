package com.fg.Annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ErrorUtils {
	public void faultyMethod(List<String>...lists) {
		//java禹岩不允许创建泛型数组，因此lists只能被当成List
		//此时相当于把List<String>赋给了List,已经发生了"堆污染"
		List[] list=lists;
		List<Integer> myList=new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		//把lists的第一个元素赋为myArray
		list[0]=myList;
		String s=lists[0].get(0);
		System.out.println(s);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		new ErrorUtils().faultyMethod(Arrays.asList("aaa"),Arrays.asList("wwww"));
	}
}
