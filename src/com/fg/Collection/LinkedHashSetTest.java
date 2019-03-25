package com.fg.Collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet<Object> books=new LinkedHashSet<>();
		books.add("雪中悍刀行");
		books.add("间客");
		//books.add("老子是癞蛤蟆");
		System.out.println(books);
		//删除 雪中悍刀行
		books.remove("雪中悍刀行");
		//重新添加 雪中悍刀行
		books.add("雪中悍刀行");
		System.out.println(books);
	}
}
