package com.fg.Annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ErrorUtils {
	public void faultyMethod(List<String>...lists) {
		//java���Ҳ��������������飬���listsֻ�ܱ�����List
		//��ʱ�൱�ڰ�List<String>������List,�Ѿ�������"����Ⱦ"
		List[] list=lists;
		List<Integer> myList=new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		//��lists�ĵ�һ��Ԫ�ظ�ΪmyArray
		list[0]=myList;
		String s=lists[0].get(0);
		System.out.println(s);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		new ErrorUtils().faultyMethod(Arrays.asList("aaa"),Arrays.asList("wwww"));
	}
}
