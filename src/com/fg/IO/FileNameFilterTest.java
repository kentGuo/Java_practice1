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
		// 如果文件名以.java结尾,或者文件对应一个路径,则返回true;
		return arg1.endsWith(".java") || new File(arg1).isDirectory();
	}

}
