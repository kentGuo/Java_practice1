package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile) throws Exception {
		// ʹ��properties�������������ļ�
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
		// ��������
				Class.forName(driver);
	}
	public void insertTransaction(String[] sqls,String sqlt) throws Exception{
		try(
			Connection conn=DriverManager.getConnection(url, user, pass);
			){
			//���浱ǰ���Զ��ύģʽ
			boolean autoCommit=conn.getAutoCommit();
			//�ر��Զ��ύ����������
			conn.setAutoCommit(false);
			try(
				//ʹ��Connection������һ��Statement����
				Statement stmt=conn.createStatement();
				){
				//ѭ�����ִ��SQL���
				for(String sql:sqls) {
					stmt.addBatch(sql);
				}
				//ͬʱִ�����е�SQL���
				int[] count=stmt.executeBatch();
				System.out.println("����"+count.length+"��SQL���");
				ResultSet rs=stmt.executeQuery(sqlt);
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+
							rs.getString(2)+"\t"
							+rs.getString(3));
				}
			}
			//�ύ����
			conn.commit();
			//�ָ�ԭ�е��Զ��ύģʽ
			conn.setAutoCommit(autoCommit);
		}
	}
	public static void main(String[] args) throws Exception {
		TransactionTest tt=new TransactionTest();
		tt.initParam("mysql.ini");
		String[] sqls=new String[] {
				"insert into student_table VALUES(null,'aaa',1);",
				"insert into student_table VALUES(null,'bbb',1);",
				"insert into student_table VALUES(null,'ccc',1);",
				"delete from student_table where java_teacher=1",
				//����ʹ��select���,���������쳣
				//"select * from student_table;",
				//��������SQL��佫��Υ�����Լ��
				//��Ϊteacher_table����û��IDΪ5�ļ�¼��
				"insert into student_table VALUES(null,'ddd',8);"
		};
		String sqlt="select * from student_table;";
		tt.insertTransaction(sqls,sqlt);
	}
}
