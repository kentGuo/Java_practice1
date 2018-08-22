package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
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

	public void createTable(String sql) throws Exception {
		
		try (
				// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
				// ʹ��Connection������һ��Statement����
				Statement stmt = conn.createStatement()) {
			// ִ��DDL,�������ݱ�
			stmt.executeUpdate(sql);

		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteDDL ed = new ExecuteDDL();
		ed.initParam("mysql.ini");
		ed.createTable("create table jdbc_test" + "(jdbc_id int auto_increment primary key," + "jdbc_name varchar(255),"
				+ "jdbc_desc text);");
		System.out.println("����ɹ�");
	}
}
