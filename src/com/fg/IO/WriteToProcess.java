package com.fg.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
	public static void main(String[] args) throws IOException {
		//����java ReadStandard����,�������и�������ӽ���
		Process p=Runtime.getRuntime().exec("java ReadStandard");
		try(
			//��p���̵����������PrintStream����
			//���������Ա������������,��p������������
			PrintStream ps=new PrintStream(p.getOutputStream())
			){
			//��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
			ps.println("��ͨ�ַ���");
			ps.println(new WriteToProcess());
		}
	}
}
//����һ��ReadStandard��,������Խ��ܱ�׼����
//������׼����д��out.txt�ļ�
class ReadStandard{
	public static void main(String[] args) {
		try (
			//ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			Scanner sc=new Scanner(System.in);
			PrintStream ps=new PrintStream(new FileOutputStream("out.txt"))
			){
			//��������һ��ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			//�ж��Ƿ�����һ��������
			while(sc.hasNext()) {
				//���������
				System.out.println("�����������:"+sc.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
