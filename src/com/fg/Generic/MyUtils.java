package com.fg.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {
		//����dest����Ԫ�ص����ͱ�����src����Ԫ�ص�������ͬ�������丸��
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
		//�˴���׼ȷ��֪�����һ�������Ƶ�Ԫ����Integer����
		//��src����Ԫ�ص�������ͬ
		Integer last=copy(ln,in);
		System.out.println(last);
		
	}
}
