package com.fg.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PerformanceTest {
	public static void main(String[] args) {
		//创建一个字符串数组
		String[] ts1=new String[900000];
		//动态初始化数组元素
		for(int i=0;i<900000;i++) {
			ts1[i]=String.valueOf(i);
		}
		ArrayList<Object> a1=new ArrayList<>();
		//将所有的数组元素加入ArrayList集合中
		for(int i=0;i<900000;i++) {
			a1.add(ts1[i]);
		}
		LinkedList<Object> ll=new LinkedList<>();
		//将所有的数组元素加入LinkedList集合中
		for(int i=0;i<900000;i++) {
			ll.add(ts1[i]);
		}
		//迭代访问ArrayList集合的所有元素，并输出迭代时间
		long start=System.currentTimeMillis();
		for(Iterator<Object> it=a1.iterator();it.hasNext();) {
			it.next();
		}
		System.out.println("迭代ArrayList集合元素 的时间:"+(System.currentTimeMillis()-start));
		//迭代访问LinedList集合的所有元素，并输出迭代时间
		start=System.currentTimeMillis();
		for(Iterator<Object> it=ll.iterator();it.hasNext();) {
			it.next();
		}
		System.out.println("迭代LinedList集合元素的时间:"+
		(System.currentTimeMillis()-start));
	}
}
