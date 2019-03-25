package com.fg.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightTest {
	//声明一个泛型方法，该泛型方法中带一个T形参
	static <T> void test(Collection<? extends T> from,Collection<T> to) {
		for(T t:from) {
			to.add(t);
		}
	}
	public static void main(String[] args) {
		List<Object> ao=new ArrayList<>();
		List<String> as=new ArrayList<>();
		//下面代码完全正常
		test(as, ao);
	}
}
