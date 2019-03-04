package com.fg.Generic;

public class ThreadException implements Runnable{
	public void firstMethod() {
		seconedMethod();
	}
	public void seconedMethod() {
		int a=5;
		int b=0;
		int c=a/b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		firstMethod();
	}
public static void main(String[] args) {
	new Thread(new ThreadException()).start();
}
}
