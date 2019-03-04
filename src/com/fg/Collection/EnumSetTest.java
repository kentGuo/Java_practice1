package com.fg.Collection;

import java.util.EnumSet;

enum Season{
	SPRING,SUMMER,FALL,WINTER
}
public class EnumSetTest {
	public static void main(String[] args) {
		//����һ��EnumSet���ϣ�����Ԫ�ؾ���Seasonö�����ȫ��ö��ֵ
		EnumSet<Season> es1=EnumSet.allOf(Season.class);
		//���[SPRING,SUMMER,FALL,WINTER]
		System.out.println(es1);
		//����һ��EnumSet�ռ��ϣ�ָ���伯��Ԫ����Season���ö��ֵ
		EnumSet<Season> es2=EnumSet.noneOf(Season.class);
		//���[]
		System.out.println(es2);
		//�ֶ��������Ԫ��
		es2.add(Season.WINTER);
		es2.add(Season.SPRING);
		//���[SPRING,WINTER]
		System.out.println(es2);
		//��ָ��ö��ֵ����EnumSet����Ԫ�غ�es4����Ԫ������ͬ������
		EnumSet<Season> es3=EnumSet.of(Season.SUMMER,Season.WINTER);
		//���[SUMMER,WINTER]
		System.out.println(es3);
		EnumSet<Season> es4=EnumSet.range(Season.SUMMER, Season.WINTER);
		//���[SUMMER,FALL,WINTER]
		System.out.println(es4);
		//�´�����EnumSet����Ԫ�غ�es4����Ԫ������ͬ������
		//es5����Ԫ��+es4����Ԫ��=Seasonö�����ȫ��ö��ֵ
		EnumSet<Season> es5=EnumSet.complementOf(es4);
		////���[SPRING]
		System.out.println(es5);
	}
}
