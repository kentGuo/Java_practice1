package com.fg.Collection;

import java.util.HashSet;
import java.util.Iterator;

class R2{
	int count;
	public R2(int count) {
		this.count=count;
	}
	@Override
	public String toString() {
		return "R[count:"+count+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj!=null&&obj.getClass()==R2.class) {
			R2 r=(R2)obj;
			if(r.count==this.count){
			return true;	
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.count;
	}
}
public class HashSetTest2 {
	public static void main(String[] args) {
		HashSet<Object> hs=new HashSet<>();
		hs.add(new R2(5));
		hs.add(new R2(-3));
		hs.add(new R2(9));
		hs.add(new R2(-2));
		//打印HashSet集合，集合元素没有重复
		System.out.println(hs);
		Iterator<Object> it=hs.iterator();
		//取出第一个预算元素
		R2 first=(R2)it.next();
		//为第一个元素的count实例变量赋值
		first.count=-3;
		//再次输出HashSet集合，集合元素有重复元素
		System.out.println(hs);
		//删除count为-3的对象
		hs.remove(new R2(-3));
		System.out.println(hs);
		//输出false
		System.out.println("hs是否包含count为-3的R2对象?"+hs.contains(new R2(-3)));
		//输出true
		System.out.println("hs是否包含count为5的R2对象?"+hs.contains(new R2(5)));
	}
}
