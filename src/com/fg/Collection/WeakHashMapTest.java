package com.fg.Collection;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<Object,Object> wm=new WeakHashMap<>();
		//��WeakHashMap��������ĸ�key-value��
		//����key���������ַ�������(û����������)
		wm.put(new String("����"), new String("����"));
		wm.put(new String("��ѧ"), new String("����"));
		wm.put(new String("Ӣ��"), new String("�е�"));
		//��WeakHashMap�����һ��key-value��
		//��key��һ��ϵͳ������ַ�������
		wm.put("java", new String("�е�"));
		//���wm���󣬽�����4��key-value��
		System.out.println(wm);
		//֪ͨϵͳ����������������
		System.gc();
		System.runFinalization();
		//��ͨ������£���ֻ����һ��key-value��
		System.out.println(wm);
	}
}
