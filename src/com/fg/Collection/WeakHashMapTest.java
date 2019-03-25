package com.fg.Collection;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<Object,Object> wm=new WeakHashMap<>();
		//向WeakHashMap中添加是哪个key-value对
		//三个key都是匿名字符串对象(没有其他对象)
		wm.put(new String("语文"), new String("良好"));
		wm.put(new String("数学"), new String("及格"));
		wm.put(new String("英文"), new String("中等"));
		//向WeakHashMap中添加一个key-value对
		//该key是一个系统缓存的字符串对象
		wm.put("java", new String("中等"));
		//输出wm对象，将看到4个key-value对
		System.out.println(wm);
		//通知系统立即进行垃圾回收
		System.gc();
		System.runFinalization();
		//在通常情况下，将只看到一个key-value对
		System.out.println(wm);
	}
}
