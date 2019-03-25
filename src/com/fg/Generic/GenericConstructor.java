package com.fg.Generic;

public class GenericConstructor {
	public static void main(String[] args) {
		//泛型构造器中的T为String类型
		new Foo("徐凤年");
		//泛型构造器中的T为Integer类型
		new Foo(200);
		//显式指定泛型构造器中的T为String类型
		//传给Foo构造器的实参也是String类型，完全正确
		new <String> Foo("李淳罡");
		//显式指定泛型构造器中的T为String类型、
		//传给Foo构造器的实参是Double类型，所以代码出错
		new <String> Foo(1.2+"1");
		System.out.println(1.2+"2");
	}
}
class Foo{
	public <T> Foo(T c){
		System.out.println(c);
	}
}
