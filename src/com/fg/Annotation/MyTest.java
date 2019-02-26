package com.fg.Annotation;

public class MyTest {
	//使用@Testtable标识注释指定该方法是可测试的
	@Testtable
	public static void ml() {}
	public static void m2() {}
	
	//使用@Testtable标识注释指定该方法是可测试的
		@Testtable
		public static void m3() {throw new RuntimeException("Boon");}
		public static void m4() {}
		
		//使用@Testtable标识注释指定该方法是可测试的
		@Testtable
		public static void m5() {}
		public static void m6() {}
		
		//使用@Testtable标识注释指定该方法是可测试的
		@Testtable
		public static void m7() {throw new RuntimeException("Crash");}
		public static void m8() {}
}
