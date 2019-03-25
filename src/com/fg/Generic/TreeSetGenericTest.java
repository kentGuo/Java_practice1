package com.fg.Generic;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetGenericTest {
	public static void main(String[] args) {
		//Comparator的实际类型是TreeSet里实际类型的父类，满足父类
		TreeSet<String> ts1=new TreeSet<>(new Comparator<Object>(
				
				) {

					@Override
					public int compare(Object o1, Object o2) {
						// TODO Auto-generated method stub
						return hashCode()>o2.hashCode()?1:hashCode()<o2.hashCode()?-1:0;
					}
		});
		ts1.add("hello");
		ts1.add("kk");
		
		TreeSet<String> ts2=new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.hashCode()>o2.hashCode()?-1:o1.hashCode()<o2.hashCode()?1:0;
			}

		});
		
		ts2.add("hello");
		ts2.add("kk");
		System.out.println(ts1);
		System.out.println(ts2);
	}
}
