package com.fg.Annotation;

import java.lang.reflect.Method;

public class ProcessorTest {
	public static void process(String clazz) throws SecurityException, ClassNotFoundException {
		int passed=0;
		int faild=0;
		//String s=clazz.toString();
		//����clazz��Ӧ����������з���
		for(Method m:Class.forName(clazz).getMethods()) {
			//����÷���ʹ����@Testtable����
			if(m.isAnnotationPresent(Testtable.class)) {
				try {
					//����m����
					m.invoke(null);
					//passed��һ
					passed++;
				}catch(Exception e) {
					System.out.println("����"+m+"����ʧ�ܣ��쳣:"+e.getCause());
					faild++;
				}
			}
		}
		//ͳ�Ʋ��Խ��
		System.out.println("��������:"+(passed+faild)+"����,����:\n"+"ʧ����"+faild+"��,\n"
				+"�ɹ���:"+passed+"����");
	}
}
