package com.fg.Exception;

import java.util.Date;

public class NullTest {
	public static void main(String[] args) {
		Date time=null;
		try {
		System.out.println(time.after(new Date()));	
		}catch (NullPointerException e) {
		System.out.println("空指针异常"+e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("未知异常"+e.getMessage());
		}
	}
}
