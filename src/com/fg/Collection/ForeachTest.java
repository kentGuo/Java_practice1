package com.fg.Collection;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args) {
		//创建一个集合
		Collection<Object> books=new HashSet<>();
		books.add("雪中悍刀行");
		books.add("间客");
		books.add("老子是癞蛤蟆");
		for(Object obj:books) {
			//此处的book变量也不是集合元素本身
			String book=(String)obj;
			System.out.println(book);
			if(book.equals("雪中悍刀行")) {
				//下面代码将引发ConcurrentModificationException异常
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
