package com.fg.Generic;


public class ThrowTest {
	public static void throwChecked(int a) throws Exception{
		if(a>0) {
			//�����׳�Exception�쳣
			//�ô��������try������ڴ�throws�����ķ�����
			throw new Exception("a��ֵ����0��������Ҫ��");
		}
	}
	public static void throwRuntime(int a) {
		if(a>0) {
			//�����׳�RuntimeException�쳣���ȿ�����ʽ������쳣
			//Ҳ����ȫ�������쳣���Ѹ��쳣�����÷��������ߴ���
			throw new RuntimeException("a��ֵ����0��������Ҫ��");
		}
	}
	public static void main(String[] args) {
		try {
			//���������׳�Checked�쳣 �ķ�����Ҫô��ʽ������쳣
			//Ҫô��main�������ٴ������׳�
			throwChecked(-3);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//���������׳�Runtime�쳣 �ķ����ȿ�����ʽ������쳣
		//Ҳ�ɲ������쳣
		throwRuntime(-1);
	}
}
