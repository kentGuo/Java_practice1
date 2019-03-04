package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

public class ListErr {
	public static void main(String[] args) {
		//创建一个纸箱保存字符串的List集合
		List strList = new ArrayList<>();
		strList.add("庆余年");
		strList.add("天骄无双");
		strList.add("步步生莲");
		//不小心把一个Integer对象丢进了集合
		strList.add(5);
		for (int i = 0; i < strList.size(); i++) {
			//因为List里取出的全部是Object，所以必须进行强制类型转换
			//最后一个元素将出现ClassCastException异常
			String str = (String) strList.get(i);
		}
	}
}
