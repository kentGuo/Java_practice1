package com.fg.Collection;

import java.util.Set;
import java.util.TreeMap;

class R1 implements Comparable<Object>{
	int count;
	public R1(int count) {
		this.count=count;
	}
	@Override
	public String toString() {
		return "R[count:"+count+"]";
	}
	//根据count来判断两个对象是否相等
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj!=null&&obj.getClass()==R1.class) {
			R1 r=(R1)obj;
			return r.count==this.count;
		}
		return false;
	}
	//根据count属性值来判断两个对象的大小
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		R1 r=(R1)o;
		return count>r.count?1:count<r.count-1?-1:0;
	}}

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Object, Object> tm=new TreeMap<>();
		tm.put(new R1(3), "java");
		tm.put(new R1(-5), "c++");
		tm.put(new R1(9), "c");
		Set<Object> set=tm.keySet();
		Object[] o2=set.toArray();
		for(Object o:o2) {
			System.out.println(o);
		}
		System.out.println(tm);
		//返回TreeMap的对个Entry对象
		System.out.println(tm.firstEntry());
		//返回该TreeMap的最后一个key值
		System.out.println(tm.lastKey());
		//返回该TreeMap的比newR1(2)大的最小key值
		System.out.println(tm.higherKey(new R1(2)));
		//返回该TreeMap的比newR1(2)小的最大的key-value对
		System.out.println(tm.lowerKey(new R1(2)));
		//返回该TreeMap的子TreeMap
		System.out.println(tm.subMap(new R1(-1), new R1(4)));
	}
}
