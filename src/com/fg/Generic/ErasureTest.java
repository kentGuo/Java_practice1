package com.fg.Generic;
class Banana<T extends Number>{
	T size;
	public T getSize() {
		return size;
	}
	public void setSize(T size) {
		this.size = size;
	}
	public Banana() {}
	public Banana(T size) {this.size=size;}
	
}
public class ErasureTest {
	Banana<Integer> a=new Banana<Integer>(6);
	//a的getSize()方法返回Integer对象
	Integer as=a.getSize();
	//把a对象赋值给Banana变量，丢失尖括号里的类型信息
	Banana<Integer> b=a;
	//b值知道size的类型是Number
	Number size1=b.getSize();
	//下面代码引起编译错误
	//Integer size2=b.getSize();
}
