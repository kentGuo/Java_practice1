package com.fg.Collection;

import java.util.HashMap;

public class NullInHashMap {
	public static void main(String[] args) {
		HashMap<Object, Object> hm=new HashMap<>();
		//��ͼ������keyΪnullֵ��key-value�Է���HashMap��
		hm.put(null, null);
		hm.put(null, null);
		//��һ��valueΪnullֵ��key-value�Է���HashMap��
		hm.put("a", null);
		//���Map����
		System.out.println(hm);
	}
}