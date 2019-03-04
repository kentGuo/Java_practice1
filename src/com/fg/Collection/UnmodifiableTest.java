package com.fg.Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {
	public static void main(String[] args) {
		//����һ�пյģ����ɸı��List����
		List<Object> unmodifiableList=Collections.emptyList();
		//����һ��ֻ��һ��Ԫ�أ��Ҳ��ɸı��set����
		Set<Object> unmodifiableSet=Collections.singleton("Java");
		//����һ����ͨ��Map����
		Map<Object, Object> source=new HashMap<>();
		source.put("����", 80);
		source.put("C++", 82);
		//������ͨ��Map�����Ӧ�Ĳ��ɱ�汾
		Map<Object, Object> unmodifiableMap=Collections.unmodifiableMap(source);
		//��������һ�д��붼������UnsupportedOperationException�쳣
		unmodifiableList.add("����Ԫ��");
		unmodifiableSet.add("����Ԫ��");
		unmodifiableMap.put("����", 90);
	}
}
