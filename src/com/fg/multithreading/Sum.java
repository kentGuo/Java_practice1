package com.fg.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

class CallTask extends RecursiveTask<Integer>{
	//每个小任务最多只累加到20个数
	private static final int THRESHOLD=20;
	private int arr[];
	private int start;
	private int end;
	//累加从start到end的数组元素
	public CallTask(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute() {
		int sum=0;
		//当end与start之间差小于THRESHOLD时，开始进行实际累加
		if(end-start<THRESHOLD) {
			for(int i=start;i<end;i++) {
				sum+=arr[i];
			}
			return sum;
		}else {
			//当end与start之间的差大于THRESHOLD时，就要累加的数超过20个小时
			//将大任务分解成两个任务
			int middle=(start+end)/2;
			CallTask left=new CallTask(arr, start, middle);
			CallTask right=new CallTask(arr, middle, end);
			//并行执行两个小任务
			left.fork();
			right.fork();
			//把两个小任务累加的结果合并起来
			return left.join()+right.join();
		}
		
	}
	
	
}
public class Sum {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] arr=new int[100];
		Random rand=new Random();
		int total=0;
		//初始化100个数字元素
		for(int i=0,len=arr.length;i<len;i++) {
			int tmp=rand.nextInt(20);
			//对数组元素赋值，并将数组元素的值添加到总和中
			total+=(arr[i]=tmp);
		}
		System.out.println(total);
		//创建一个通用池
		ForkJoinPool pool=ForkJoinPool.commonPool();
		//提交可分解的CallTask任务
		Future<Integer> future=pool.submit(new CallTask(arr, 0, arr.length));
		System.out.println(future.get());
		//关闭线程池
		pool.shutdown();
	}
}
