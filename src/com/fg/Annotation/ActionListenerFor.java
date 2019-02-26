package com.fg.Annotation;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
	//����һ����Ա����
	//��listener��Ա�������ڱ��������ʵ����
	Class<? extends ActionListener> listener();
}
