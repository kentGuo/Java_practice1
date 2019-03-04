package com.fg.Collection;

import java.util.TreeSet;
class J implements Comparable<Object>
{
	int count;
	public J(int count)
	{
		this.count=count;
	}
	@Override
	public String toString() {
		return "R[count:"+count+"]";
	}
	//��дequals()����������count���ж��Ƿ����
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if(obj!=null&&obj.getClass()==J.class) {
			J r=(J)obj;
			if(r.count==this.count)
			return true;
		}
		return false;
	}
	//��дcompareTo()����������count���Ƚϴ�С
	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		J r=(J)obj;
		
		return count>r.count?1:count<r.count?-1:0;
	}}
public class TreeSetTest3 {
	public static void main(String[] args) {
		TreeSet<J> ts=new TreeSet<>();
		ts.add(new J(5));
		ts.add(new J(-3));
		ts.add(new J(9));
		ts.add(new J(-2));
		//��ӡTreeSet���ϣ�����Ԫ�ض����������е�
		System.out.println(ts);
		//ȡ����һ��Ԫ��
		J first=(J)ts.first();
		//�Ե�һ��Ԫ�ص�count��ֵ
		first.count=20;
		//ȡ�����һ��Ԫ��
		J last=(J)ts.last();
		//�����һ��Ԫ�ص�count��ֵ����ڶ���Ԫ�ص�count��ͬ
		last.count=-2;
		//�ٴ����������TreeSet���Ԫ�ش�������״̬�������ظ�Ԫ��
		System.out.println(ts);
		//ɾ��Field���ı��Ԫ�أ�ɾ��ʧ��
		System.out.println(ts.remove(new J(-2)));
		System.out.println(ts);
		//ɾ��Fieldû�иı��Ԫ�أ�ɾ���ɹ�
		System.out.println(ts.remove(new J(5)));
		System.out.println(ts);
	}
}
