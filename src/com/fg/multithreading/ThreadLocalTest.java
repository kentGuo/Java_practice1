package com.fg.multithreading;
class AccountPool{
	/**
	 * 定义一个ThreadLocal类型的变量，该变量将是一个线程布局变量
	 * 每个线程都会保留该变量的一个副本
	 */
	private ThreadLocal<String> name=new ThreadLocal<>();
	public AccountPool(String str) {
		// TODO Auto-generated constructor stub
		this.name.set(str);
		//下面代码用于访问当前线程的name副本的值
		System.out.println("---"+this.name.get());
	}
	//name的getter和setter方法
	public String getName() {
		return name.get();
	}
	public void setName(String str) {
		this.name.set(str);
	}
	
}
class MyThreadPool extends Thread{
	//定义一个AccountPool类型的成员变量
	private AccountPool account;
	public MyThreadPool(AccountPool account,String name) {
		super(name);
		this.account=account;
	}
	@Override
	public void run() {
		//循环10次
		for(int i=0;i<10;i++) {
			//当i等于6时输出将账户名替换成当前线程名
			if(i==6) {
				account.setName(getName());
			}
			//输出同一个账户的账户名和循环变量
			System.out.println(account.getName()+"账户的值:"+i);
		}
	}
}
public class ThreadLocalTest {
	public static void main(String[] args) {
		//启动两个线程，两个线程共享同一个AccountPool
		AccountPool at=new AccountPool("初始名");
		/**
		 * 虽然两个线程共享同一个账户，也就是只有一个账户名
		 * 但由于账户名是ThreadLocal类型的，所以每个线程
		 * 都完全拥有各自的账户名副本，因此当i的等于6之后，将会看到
		 * 两个线程访问同一个账户时出现不同的账户名
		 */
		new MyThreadPool(at, "线程甲").start();
		new MyThreadPool(at, "线程乙").start();
	}
}
