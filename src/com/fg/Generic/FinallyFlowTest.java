package com.fg.Generic;

public class FinallyFlowTest {
	static boolean test() {
		try {
			//因为final路块包含了return语句
			//所以下面的return语句失去作用
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
