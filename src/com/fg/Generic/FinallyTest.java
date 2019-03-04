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
			//return语句强制方法返回
			//return;
			//如果在异常处理代码中使用System.exit(1)语句来退出虚拟机，则finally块不会执行
			System.exit(1);
		}
		finally {
			// TODO: handle finally clause
			//关闭磁盘文件，回收资源
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			System.out.println("执行finally块里的资源回收");
		}
	}
}
