package com.fg.Collection;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {
	public static void main(String[] args) {
		List<Object> fixedList=Arrays.asList("1","2","3");
		//��ȡfixedList��ʵ���࣬�����Arrays$ArrayList
		System.out.println(fixedList.getClass());
		//����fixedList�ļ���Ԫ��
		for(int i=0;i<fixedList.size();i++) {
			System.out.println(fixedList.get(i));
		}
		//��ͼ���ӣ�ɾ��Ԫ�ض�������UnsupportedOperationException�쳣
		fixedList.add("4");
		fixedList.remove("4");
	}
}
