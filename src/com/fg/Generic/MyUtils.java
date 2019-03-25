package com.fg.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {
		//下面dest集合元素的类型必须与src集合元素的类型相同，或是其父类
	public static <T> T copy(Collection<? super T> dest,Collection<T> src){
		T last=null;
		for(T ele:src) {
			last=ele;
			dest.add(ele);
		}
		return last;
	}
	public static <T> void copy2(Collection<T> dest,Collection<? extends T> src) {}
	public static <T> T copy3(Collection<? super T> dest,Collection<T> src) {
		return null;}
	public static void main(String[] args) {
		List<Number> ln=new ArrayList<>();
		List<Integer> in=new ArrayList<>();
		in.add(5);
		in.add(2);
		in.add(51);
		in.add(54);
		in.add(15);
		in.add(53);
		//此处可准确地知道最后一个被复制的元素是Integer类型
		//与src集合元素的类型相同
		Integer last=copy(ln,in);
		System.out.println(last);
		
	}
}
