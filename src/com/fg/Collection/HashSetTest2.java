package com.fg.Collection;

import java.util.HashSet;
import java.util.Iterator;

class R2{
	int count;
	public R2(int count) {
		this.count=count;
	}
	@Override
	public String toString() {
		return "R[count:"+count+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj!=null&&obj.getClass()==R2.class) {
			R2 r=(R2)obj;
			if(r.count==this.count){
			return true;	
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.count;
	}
}
public class HashSetTest2 {
	public static void main(String[] args) {
		HashSet<Object> hs=new HashSet<>();
		hs.add(new R2(5));
		hs.add(new R2(-3));
		hs.add(new R2(9));
		hs.add(new R2(-2));
		//��ӡHashSet���ϣ�����Ԫ��û���ظ�
		System.out.println(hs);
		Iterator<Object> it=hs.iterator();
		//ȡ����һ��Ԥ��Ԫ��
		R2 first=(R2)it.next();
		//Ϊ��һ��Ԫ�ص�countʵ��������ֵ
		first.count=-3;
		//�ٴ����HashSet���ϣ�����Ԫ�����ظ�Ԫ��
		System.out.println(hs);
		//ɾ��countΪ-3�Ķ���
		hs.remove(new R2(-3));
		System.out.println(hs);
		//���false
		System.out.println("hs�Ƿ����countΪ-3��R2����?"+hs.contains(new R2(-3)));
		//���true
		System.out.println("hs�Ƿ����countΪ5��R2����?"+hs.contains(new R2(5)));
	}
}
