package com.fg.Annotation;

public class Fruit {
	public void info() {
		//@Deprecated
		System.out.println("ˮ����info����...");
	}
	public static void main(String[] args) {
		new Apple().info();
	}
}
class Apple extends Fruit{

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("ƻ����дˮ����info����....");
		super.info();
	}
	
}
