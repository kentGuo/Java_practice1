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



//ָ���ɴ���@Persistent,@Id,@Property����Annotation
@SupportedAnnotationTypes({"Persistent","Id","Property"})
public class HibernateAnnoatationProcessor extends AbstractProcessor{
	//ѭ������ÿ����Ҫ����ĳ������
	@Override
	public boolean process(Set<? extends TypeElement> arg0, RoundEnvironment arg1) {
		// TODO Auto-generated method stub
		//����һ���ļ���������������ɶ�����ļ�
		PrintStream ps=null;
		try {
			//����ÿ����@Persistent���ε�class�ļ�
			for(Element t:arg1.getElementsAnnotatedWith(Persistent.class))
			{
				//��ȡ���ڴ��������
				Name clazzName=t.getSimpleName();
				//��ȡ�ඨ��ǰ��@Persistent Annotation
				Persistent per=t.getAnnotation(Persistent.class);
				//�����ļ������
				ps=new PrintStream(new FileOutputStream(clazzName+".hbm.xml"));
				//ִ�����
				ps.println("<?xml version=\"1.0\"?>");
				ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
				ps.println("	\"-//Hibernate/Hibernate "
					+ "Mapping DTD 3.0//EN\"");
				ps.println("	\"http://www.hibernate.org/dtd/"
					+ "hibernate-mapping-3.0.dtd\">");
				ps.println("<hibernate-mapping>");
				ps.print("	<class name=\"" + t);
				for(Element f:t.getEnclosedElements()) {
					//ֻ����Field�ϵ�Annotation
					if(f.getKind()==ElementKind.FIELD) {
						//��ȡField����ǰ��@Id Annotation
						Id id=f.getAnnotation(Id.class);
						//��@Id Annotation����ʱ���<id.../>Ԫ��
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
						//��ȡField����ǰ��@Property Annotation
						Property p=f.getAnnotation(Property.class);
						//��@Property Annotation����ʱ���<property.../>Ԫ��
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
