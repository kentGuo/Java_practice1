package com.fg.Exception;

import java.util.Date;

public class NullTest {
	public static void main(String[] args) {
		Date time=null;
		try {
		System.out.println(time.after(new Date()));	
		}catch (NullPointerException e) {
		System.out.println("��ָ���쳣"+e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("δ֪�쳣"+e.getMessage());
		}
	}
}
