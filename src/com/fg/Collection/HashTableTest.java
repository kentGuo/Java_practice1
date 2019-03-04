package com.fg.Collection;

import java.util.Hashtable;

class A1{
	int count;
	public A1(int count) {
		this.count=count;
	}
	//����count��ֵ���ж����������Ƿ����
	@Override
	public boolean equals(Object obj) {
		if(obj==this)return true;
		if(obj!=null&&obj.getClass()==A1.class) {
			A1 a=(A1)obj;
			return this.count==a.count;
		}
		return false;
		
	}
	//����count������hashCodeֵ
	@Override
	public int hashCode() {
		return this.count;
	}
}
//��дequals������B1�������κζ���ͨ��equals()�����Ƚ����
class B1{
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<Object, Object> ht=new Hashtable<>();
		ht.put(new A1(60000), "���java����");
		ht.put(new A1(87653), "������Java EE��ҵ��Ӧ��ʵս");
		ht.put(new A1(1232), new B1());
		System.out.println(ht);
		//ֻҪ��������ͨ��equals()�����ȽϷ���true
		//HashTable����Ϊ��������ȵ�value
		//����HashTable����һ��B1����
		//�����κζ���ͨ��equals()�����Ƚ϶���ȣ������������true
		System.out.println(ht.contains("�����ַ���"));
		//ֻҪ����A1�����count��ȣ�����ͨ��equals()�����ȽϷ���true����HashCodeֵ���
		System.out.println(ht.contains(new A1(87653)));
		//������߿���ɾ�����һ��key-value��
		ht.remove(new A1(1232));
		//ͨ������HashTable������key��ɵ�Set����
		//�Ӷ�����HashTable��ÿ��Key-value��
		for(Object key:ht.keySet()) {
			System.out.println(key+"--------->");
			System.out.println(ht.get(key)+"\n");
		}
	}
}
