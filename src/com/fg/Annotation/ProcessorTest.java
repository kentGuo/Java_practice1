package com.fg.Annotation;

import java.lang.reflect.Method;

public class ProcessorTest {
	public static void process(String clazz) throws SecurityException, ClassNotFoundException {
		int passed=0;
		int faild=0;
		//String s=clazz.toString();
		//遍历clazz对应的类里的所有方法
		for(Method m:Class.forName(clazz).getMethods()) {
			//如果该方法使用了@Testtable修饰
			if(m.isAnnotationPresent(Testtable.class)) {
				try {
					//调用m方法
					m.invoke(null);
					//passed加一
					passed++;
				}catch(Exception e) {
					System.out.println("方法"+m+"运行失败，异常:"+e.getCause());
					faild++;
				}
			}
		}
		//统计测试结果
		System.out.println("共运行了:"+(passed+faild)+"方法,其中:\n"+"失败了"+faild+"个,\n"
				+"成功了:"+passed+"个！");
	}
}
