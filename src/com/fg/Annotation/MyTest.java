package com.fg.Annotation;

public class MyTest {
	//ʹ��@Testtable��ʶע��ָ���÷����ǿɲ��Ե�
	@Testtable
	public static void ml() {}
	public static void m2() {}
	
	//ʹ��@Testtable��ʶע��ָ���÷����ǿɲ��Ե�
		@Testtable
		public static void m3() {throw new RuntimeException("Boon");}
		public static void m4() {}
		
		//ʹ��@Testtable��ʶע��ָ���÷����ǿɲ��Ե�
		@Testtable
		public static void m5() {}
		public static void m6() {}
		
		//ʹ��@Testtable��ʶע��ָ���÷����ǿɲ��Ե�
		@Testtable
		public static void m7() {throw new RuntimeException("Crash");}
		public static void m8() {}
}
