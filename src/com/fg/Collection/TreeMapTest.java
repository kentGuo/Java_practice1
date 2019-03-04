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
	//����count���ж����������Ƿ����
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj!=null&&obj.getClass()==R1.class) {
			R1 r=(R1)obj;
			return r.count==this.count;
		}
		return false;
	}
	//����count����ֵ���ж���������Ĵ�С
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
		//����TreeMap�ĶԸ�Entry����
		System.out.println(tm.firstEntry());
		//���ظ�TreeMap�����һ��keyֵ
		System.out.println(tm.lastKey());
		//���ظ�TreeMap�ı�newR1(2)�����Сkeyֵ
		System.out.println(tm.higherKey(new R1(2)));
		//���ظ�TreeMap�ı�newR1(2)С������key-value��
		System.out.println(tm.lowerKey(new R1(2)));
		//���ظ�TreeMap����TreeMap
		System.out.println(tm.subMap(new R1(-1), new R1(4)));
	}
}
