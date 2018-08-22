package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import java.sql.ResultSetMetaData;

public class ExecuteSQL {
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
	}

	public void executeSQL(String sql) throws Exception {
		// ��������
		Class.forName(driver);
		try (
				// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
				// ʹ��Connection������һ��Statement����
				Statement stmt = conn.createStatement()) {
			// ִ��SQL���,���ص�booleanֵ��ʾ�Ƿ����ResultSet
			boolean hasResultSet=stmt.execute(sql);
			//���ִ�к���ReseultSet�����
			if(hasResultSet) {
				try(//��ȡ�����
				ResultSet rs=stmt.getResultSet()){
					//ResultSetMetaData�����ڷ����������Ԫ���ݽӿ�
					ResultSetMetaData rsmd=rs.getMetaData();
					int columnCount=rsmd.getColumnCount();
					//�������ResultSet����
					while(rs.next()) {
						//�������ÿ�е�ֵ
						for(int i=0;i<columnCount;i++) {
							System.out.println(rs.getString(i+1)+"\t");
						}
						System.out.println("\n");
					}
				}
				
			}else {
				System.out.println("��SQL���Ӱ��ļ�¼��"+stmt.getUpdateCount()+"��");
			}
			

		}
	}
	public static void main(String[] args) throws Exception {
		ExecuteSQL es=new ExecuteSQL();
		es.initParam("mysql.ini");
		System.out.println("----ִ��ɾ�����DDL���-----");
		es.executeSQL("drop table if exists my_test");
		System.out.println("----ִ�н����DDL���-----");
		es.executeSQL("create table my_test"+"(test_id int auto_increment primary key,"
		+"test_name varchar(255))");
		System.out.println("----ִ�в������ݵ�DML���-----");
		es.executeSQL("insert into my_test(test_name) "
		+"select student_name from student_table2");
		System.out.println("----ִ�в�ѯ���ݵĲ�ѯ���-----");
		es.executeSQL("select * from my_test;");
	}
}
