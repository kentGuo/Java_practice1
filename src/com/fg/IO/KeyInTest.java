package com.fg.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyInTest {
	public static void main(String[] args) {
		try(
			//��System.in����ת����Reader����
			InputStreamReader reader=new InputStreamReader(System.in);
			//����ͨ��Reader��װ��BufferedReader
				BufferedReader br=new BufferedReader(reader);
			){
			String buffer=null;
			//����ѭ����ʽ�����ж�ȡ
			while((buffer=br.readLine())!=null) {
				//�����ȡ���ַ���Ϊ'exit',������˳�
				if(buffer.equals("exit")) {
					System.exit(1);
				}
			//��ӡ��ȡ������
				System.out.println("���������Ϊ:"+buffer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
