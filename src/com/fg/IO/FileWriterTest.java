package com.fg.IO;

import java.io.FileWriter;

public class FileWriterTest {
	public static void main(String[] args) {
		try (
			FileWriter fw=new FileWriter("poem.txt");	
			){
			fw.write("         ��ɪ - ������\r\n");
			fw.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ\r\n");
			fw.write("ׯ�������Ժ��������۴����жž顣\r\n");
			fw.write("�׺����������ᣬ������ů�����̡�\r\n");
			fw.write("����ɴ���׷�䣿ֻ�ǵ�ʱ���Ȼ��\r\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
