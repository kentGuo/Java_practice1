package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

public class ListErr {
	public static void main(String[] args) {
		//����һ��ֽ�䱣���ַ�����List����
		List strList = new ArrayList<>();
		strList.add("������");
		strList.add("�콾��˫");
		strList.add("��������");
		//��С�İ�һ��Integer���󶪽��˼���
		strList.add(5);
		for (int i = 0; i < strList.size(); i++) {
			//��ΪList��ȡ����ȫ����Object�����Ա������ǿ������ת��
			//���һ��Ԫ�ؽ�����ClassCastException�쳣
			String str = (String) strList.get(i);
		}
	}
}
