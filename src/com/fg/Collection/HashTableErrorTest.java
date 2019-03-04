package com.fg.Collection;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableErrorTest {
	public static void main(String[] args) {
		Hashtable<Object, Object> ht=new Hashtable<>();
		//此处的A1类与前一个程序的A1类是同一个类
		ht.put(new A1(60000),"疯狂Java讲义");
		ht.put(new A1(87653),"轻量级Java EE企业级应用实战");
		//获得HashTable的key Set集合对应的Iterator迭代器
		Iterator<Object> it=ht.keySet().iterator();
		//取出Map中第一个key
		A1 first=(A1)it.next();
		first.count=87563;
		//输出{com.fg.Collection.A1@1560b=疯狂Java讲义, com.fg.Collection.A1@15665=轻量级Java EE企业级应用实战}
		System.out.println(ht);
		//只能删除没有被修改过的key所对应的key-value对
		ht.remove(new A1(87563));
		System.out.println(ht);
		//无法获取剩下的value，下面两行代码都将输出null
		System.out.println(ht.get(new A1(87563)));
		System.out.println(ht.get(new A1(60000)));
		
	}
}
