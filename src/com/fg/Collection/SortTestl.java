package com.fg.Collection;

import java.util.ArrayList;
import java.util.Collections;

public class SortTestl {
	public static void main(String[] args) {
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		//���[2, -5, 3, 0]
		System.out.println(nums);
		//��List����Ԫ�صĴ���ת
		Collections.reverse(nums);
		//���[0, 3, -5, 2]
		System.out.println(nums);
		//��List����Ԫ�ذ����˳������
		Collections.shuffle(nums);
		//ÿ������Ĵ��򲻹̶�
		System.out.println(nums);
		//��List����Ԫ�ذ���Ȼ˳������
		Collections.sort(nums);
		//���[-5, 2, 3, 0]
		System.out.println(nums);
		//��������List���±�Ϊ0��1��λ��
		Collections.swap(nums, 0, 1);
		System.out.println(nums);
		//���±�Ϊ1�ĺ�������Ԫ�ؼ����Ƶ�ǰ��
		Collections.rotate(nums, 1);
		System.out.println(nums);
		Collections.rotate(nums, -1);
		System.out.println(nums);
	}
}
