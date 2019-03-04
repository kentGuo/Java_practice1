package com.fg.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		//创建一个集合
		Collection<Object> books=new HashSet<>();
		books.add("雪中悍刀行");
		books.add("间客");
		books.add("老子是癞蛤蟆");
		//获取books集合对应的迭代器
		Iterator<Object> it=books.iterator();
		while(it.hasNext()) {
			//it.next()方法返回的数据类型是Object类型
			//需要强制转换类型
			String book=(String)it.next();
			System.out.println(book);
			if(book.equals("雪中悍刀行"))
			{
				//从集合中删除上一次next方法返回的元素
				it.remove();
			}
			//对book变量赋值，不会改变集合元素本身
			book="测试字符串";
		}
		System.out.println(books);
	}
}
