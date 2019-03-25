package com.fg.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//使用JDK的元数据Annotation:@Retention
@Retention(RetentionPolicy.RUNTIME)
//使用JDK元数据Annotation:@Target
@Target(ElementType.METHOD)
public @interface Testtable {
	
}
