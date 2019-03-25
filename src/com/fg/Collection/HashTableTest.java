package com.fg.Collection;

import java.util.Hashtable;

class A1{
	int count;
	public A1(int count) {
		this.count=count;
	}
	//根据count的值来判断两个对象是否相等
	@Override
	public boolean equals(Object obj) {
		if(obj==this)return true;
		if(obj!=null&&obj.getClass()==A1.class) {
			A1 a=(A1)obj;
			return this.count==a.count;
		}
		return false;
		
	}
	//根据count来计算hashCode值
	@Override
	public int hashCode() {
		return this.count;
	}
}
//重写equals方法，B1对象与任何对象通过equals()方法比较相等
class B1{
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<Object, Object> ht=new Hashtable<>();
		ht.put(new A1(60000), "疯狂java讲义");
		ht.put(new A1(87653), "轻量级Java EE企业级应用实战");
		ht.put(new A1(1232), new B1());
		System.out.println(ht);
		//只要两个对象通过equals()方法比较返回true
		//HashTable就认为他们是相等的value
		//由于HashTable中有一个B1对象
		//它与任何对象通过equals()方法比较都相等，所以下面输出true
		System.out.println(ht.contains("测试字符串"));
		//只要连个A1对象的count相等，它们通过equals()方法比较返回true，且HashCode值相等
		System.out.println(ht.contains(new A1(87653)));
		//线面渔具可以删除最后一个key-value对
		ht.remove(new A1(1232));
		//通过返回HashTable的所有key组成的Set集合
		//从而便利HashTable的每个Key-value对
		for(Object key:ht.keySet()) {
			System.out.println(key+"--------->");
			System.out.println(ht.get(key)+"\n");
		}
	}
}
