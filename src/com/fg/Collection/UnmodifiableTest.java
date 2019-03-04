package com.fg.Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {
	public static void main(String[] args) {
		//创建一盒空的，不可改变的List对象
		List<Object> unmodifiableList=Collections.emptyList();
		//创建一个只有一个元素，且不可改变的set对象
		Set<Object> unmodifiableSet=Collections.singleton("Java");
		//创建一个普通的Map对象
		Map<Object, Object> source=new HashMap<>();
		source.put("语文", 80);
		source.put("C++", 82);
		//返回普通的Map对象对应的不可变版本
		Map<Object, Object> unmodifiableMap=Collections.unmodifiableMap(source);
		//下面任意一行代码都将引发UnsupportedOperationException异常
		unmodifiableList.add("测试元素");
		unmodifiableSet.add("测试元素");
		unmodifiableMap.put("语文", 90);
	}
}
