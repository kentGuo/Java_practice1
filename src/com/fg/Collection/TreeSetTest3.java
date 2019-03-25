package com.fg.Collection;

import java.util.TreeSet;
class J implements Comparable<Object>
{
	int count;
	public J(int count)
	{
		this.count=count;
	}
	@Override
	public String toString() {
		return "R[count:"+count+"]";
	}
	//重写equals()方法，根据count来判断是否相等
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj!=null&&obj.getClass()==J.class) {
			J r=(J)obj;
			if(r.count==this.count)
			return true;
		}
		return false;
	}
	//重写compareTo()方法，根据count来比较大小
	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		J r=(J)obj;
		
		return count>r.count?1:count<r.count?-1:0;
	}}
public class TreeSetTest3 {
	public static void main(String[] args) {
		TreeSet<J> ts=new TreeSet<>();
		ts.add(new J(5));
		ts.add(new J(-3));
		ts.add(new J(9));
		ts.add(new J(-2));
		//打印TreeSet集合，集合元素都是有序排列的
		System.out.println(ts);
		//取出第一个元素
		J first=(J)ts.first();
		//对第一个元素的count赋值
		first.count=20;
		//取出最后一个元素
		J last=(J)ts.last();
		//对最后一个元素的count赋值，与第二个元素的count相同
		last.count=-2;
		//再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
		System.out.println(ts);
		//删除Field被改变的元素，删除失败
		System.out.println(ts.remove(new J(-2)));
		System.out.println(ts);
		//删除Field没有改变的元素，删除成功
		System.out.println(ts.remove(new J(5)));
		System.out.println(ts);
	}
}
