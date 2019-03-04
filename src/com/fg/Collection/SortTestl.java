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
		//输出[2, -5, 3, 0]
		System.out.println(nums);
		//将List集合元素的次序反转
		Collections.reverse(nums);
		//输出[0, 3, -5, 2]
		System.out.println(nums);
		//将List集合元素按随机顺序排序
		Collections.shuffle(nums);
		//每次输出的次序不固定
		System.out.println(nums);
		//将List集合元素按自然顺序排序
		Collections.sort(nums);
		//输出[-5, 2, 3, 0]
		System.out.println(nums);
		//交换集合List的下标为0和1的位置
		Collections.swap(nums, 0, 1);
		System.out.println(nums);
		//把下标为1的后面所有元素集体移到前面
		Collections.rotate(nums, 1);
		System.out.println(nums);
		Collections.rotate(nums, -1);
		System.out.println(nums);
	}
}
