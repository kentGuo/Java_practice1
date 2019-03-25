package com.fg.Annotation;

public class Fruit {
	public void info() {
		//@Deprecated
		System.out.println("水果的info方法...");
	}
	public static void main(String[] args) {
		new Apple().info();
	}
}
class Apple extends Fruit{

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("苹果重写水果的info方法....");
		super.info();
	}
	
}
