package com.fg.IO;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterTest {
	public static void main(String[] args) {
		File file = new File(".\\src\\com\\fg\\IO\\");
		String[] nameList = file.list(new MyFileNameFilter());
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}

class MyFileNameFilter implements FilenameFilter {

	@Override
	public boolean accept(File arg0, String arg1) {
		// TODO Auto-generated method stub
		// ����ļ�����.java��β,�����ļ���Ӧһ��·��,�򷵻�true;
		return arg1.endsWith(".java") || new File(arg1).isDirectory();
	}

}
