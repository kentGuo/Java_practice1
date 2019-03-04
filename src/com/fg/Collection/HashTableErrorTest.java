package com.fg.Collection;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableErrorTest {
	public static void main(String[] args) {
		Hashtable<Object, Object> ht=new Hashtable<>();
		//�˴���A1����ǰһ�������A1����ͬһ����
		ht.put(new A1(60000),"���Java����");
		ht.put(new A1(87653),"������Java EE��ҵ��Ӧ��ʵս");
		//���HashTable��key Set���϶�Ӧ��Iterator������
		Iterator<Object> it=ht.keySet().iterator();
		//ȡ��Map�е�һ��key
		A1 first=(A1)it.next();
		first.count=87563;
		//���{com.fg.Collection.A1@1560b=���Java����, com.fg.Collection.A1@15665=������Java EE��ҵ��Ӧ��ʵս}
		System.out.println(ht);
		//ֻ��ɾ��û�б��޸Ĺ���key����Ӧ��key-value��
		ht.remove(new A1(87563));
		System.out.println(ht);
		//�޷���ȡʣ�µ�value���������д��붼�����null
		System.out.println(ht.get(new A1(87563)));
		System.out.println(ht.get(new A1(60000)));
		
	}
}
