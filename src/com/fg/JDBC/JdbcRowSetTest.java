package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcRowSetTest {
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
		//��������
		Class.forName(driver);
	}
	public void update(String sql) throws Exception{
		try(
			//��ȡ���ݿ�����
				Connection conn=DriverManager.getConnection(url, user, pass);
				//����JdbcRowSetImpl����
			//	JdbcRowSet jdbcRs=new JdbcRowSetImpl(conn)
			){}
	}
}
