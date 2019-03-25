package com.fg.Annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	//处理Annotation的方法，其中obj是包含Annotation的对象
	public static void processAnnotations(Object o) {
		try {
			//获取o对象的类
			Class cl=o.getClass();
			//获取指定o对象的所有Field,并遍历每个Field
			for(Field f:cl.getDeclaredFields()) {
				//指定Field设置成自由访问
				f.setAccessible(true);
				//获取指定Field上ActionListenerFor类型的Annotation
				ActionListenerFor a=f.getAnnotation(ActionListenerFor.class);
				//获取f Field实际对应的对象
				Object fo=f.get(o);
				//如果f是AbstractButton的是,且a不为null
				if(a!=null&&fo!=null&&fo instanceof AbstractButton)
				{
					//获取a指数里的元数据listener(它是一个监听器类)
					Class<? extends ActionListener> listenerClazz=a.listener();
					//使用反射来创建listener类的对象
					ActionListener a1=listenerClazz.newInstance();
					AbstractButton ab=(AbstractButton)fo;
					//为ab按钮添加事件监听器
					ab.addActionListener(a1);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
