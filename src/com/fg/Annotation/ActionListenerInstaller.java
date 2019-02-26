package com.fg.Annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	//����Annotation�ķ���������obj�ǰ���Annotation�Ķ���
	public static void processAnnotations(Object o) {
		try {
			//��ȡo�������
			Class cl=o.getClass();
			//��ȡָ��o���������Field,������ÿ��Field
			for(Field f:cl.getDeclaredFields()) {
				//ָ��Field���ó����ɷ���
				f.setAccessible(true);
				//��ȡָ��Field��ActionListenerFor���͵�Annotation
				ActionListenerFor a=f.getAnnotation(ActionListenerFor.class);
				//��ȡf Fieldʵ�ʶ�Ӧ�Ķ���
				Object fo=f.get(o);
				//���f��AbstractButton����,��a��Ϊnull
				if(a!=null&&fo!=null&&fo instanceof AbstractButton)
				{
					//��ȡaָ�����Ԫ����listener(����һ����������)
					Class<? extends ActionListener> listenerClazz=a.listener();
					//ʹ�÷���������listener��Ķ���
					ActionListener a1=listenerClazz.newInstance();
					AbstractButton ab=(AbstractButton)fo;
					//Ϊab��ť����¼�������
					ab.addActionListener(a1);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
