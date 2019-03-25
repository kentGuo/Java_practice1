package com.fg.Annotation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;



//指定可处理@Persistent,@Id,@Property三个Annotation
@SupportedAnnotationTypes({"Persistent","Id","Property"})
public class HibernateAnnoatationProcessor extends AbstractProcessor{
	//循环处理每个需要处理的程序对象
	@Override
	public boolean process(Set<? extends TypeElement> arg0, RoundEnvironment arg1) {
		// TODO Auto-generated method stub
		//定义一个文件输出流，用于生成额外的文件
		PrintStream ps=null;
		try {
			//遍历每个被@Persistent修饰的class文件
			for(Element t:arg1.getElementsAnnotatedWith(Persistent.class))
			{
				//获取正在处理的类名
				Name clazzName=t.getSimpleName();
				//获取类定义前的@Persistent Annotation
				Persistent per=t.getAnnotation(Persistent.class);
				//创建文件输出流
				ps=new PrintStream(new FileOutputStream(clazzName+".hbm.xml"));
				//执行输出
				ps.println("<?xml version=\"1.0\"?>");
				ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
				ps.println("	\"-//Hibernate/Hibernate "
					+ "Mapping DTD 3.0//EN\"");
				ps.println("	\"http://www.hibernate.org/dtd/"
					+ "hibernate-mapping-3.0.dtd\">");
				ps.println("<hibernate-mapping>");
				ps.print("	<class name=\"" + t);
				for(Element f:t.getEnclosedElements()) {
					//只处理Field上的Annotation
					if(f.getKind()==ElementKind.FIELD) {
						//获取Field定义前的@Id Annotation
						Id id=f.getAnnotation(Id.class);
						//当@Id Annotation存在时输出<id.../>元素
						if(id!=null) {
							ps.println("		<id name=\""
									+ f.getSimpleName()
									+ "\" column=\"" + id.column()
									+ "\" type=\"" + id.type()
									+ "\">");
								ps.println("		<generator class=\""
									+ id.generator() + "\"/>");
								ps.println("		</id>");
						}
						//获取Field定义前的@Property Annotation
						Property p=f.getAnnotation(Property.class);
						//当@Property Annotation存在时输出<property.../>元素
						if(p!=null) {
							ps.println("		<property name=\""
									+ f.getSimpleName()
									+ "\" column=\"" + p.column()
									+ "\" type=\"" + p.type()
									+ "\"/>");
						}
					}
				}
				ps.println("   </class>");
				ps.println("<hibernate_mapping>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		return true;
	}
}
