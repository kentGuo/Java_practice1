package com.fg.Generic;

public class FinallyFlowTest {
	static boolean test() {
		try {
			//��Ϊfinal·�������return���
			//���������return���ʧȥ����
			return true;
		} finally {
			// TODO: handle exception
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		boolean a=test();
		System.out.println(a);
	}
}
