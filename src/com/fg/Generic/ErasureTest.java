package com.fg.Generic;
class Banana<T extends Number>{
	T size;
	public T getSize() {
		return size;
	}
	public void setSize(T size) {
		this.size = size;
	}
	public Banana() {}
	public Banana(T size) {this.size=size;}
	
}
public class ErasureTest {
	Banana<Integer> a=new Banana<Integer>(6);
	//a��getSize()��������Integer����
	Integer as=a.getSize();
	//��a����ֵ��Banana��������ʧ���������������Ϣ
	Banana<Integer> b=a;
	//bֵ֪��size��������Number
	Number size1=b.getSize();
	//�����������������
	//Integer size2=b.getSize();
}
