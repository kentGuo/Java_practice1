package com.fg.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ʹ��JDK��Ԫ����Annotation:@Retention
@Retention(RetentionPolicy.RUNTIME)
//ʹ��JDKԪ����Annotation:@Target
@Target(ElementType.METHOD)
public @interface Testtable {
	
}
