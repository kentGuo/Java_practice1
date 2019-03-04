package com.fg.Generic;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("a.txt");
		}catch(IOException e){
			System.err.println(e.getMessage());
			//return���ǿ�Ʒ�������
			//return;
			//������쳣���������ʹ��System.exit(1)������˳����������finally�鲻��ִ��
			System.exit(1);
		}
		finally {
			// TODO: handle finally clause
			//�رմ����ļ���������Դ
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			System.out.println("ִ��finally�������Դ����");
		}
	}
}
