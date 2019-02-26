package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
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

	public void insertUserStatement() throws Exception {
		long start = System.currentTimeMillis();
		try (
				// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
				// ʹ��Connection������һ��Statement����
				Statement stmt = conn.createStatement()) {
			// ��Ҫʹ��100��SQL���������100����¼
			for (int i = 0; i < 100; i++) {
				stmt.executeUpdate("insert into student_table1 values(" + " null,'name" + i + "',1)");
			}
			System.out.println("ʹ��Statement��ʱ:" + (System.currentTimeMillis() - start));
		}
	}

	public void insertUserPrepare() throws Exception {
		long start = System.currentTimeMillis();
		try (
				// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
		//ʹ��Connection ������һ��PreparedStatement����
				PreparedStatement pstmt=conn.prepareStatement("insert into student_table1 values(null,?,1)");
		) {
			//100��ΪPreparedStatement�Ĳ�����ֵ,�Ϳ��Բ���100����¼
			for(int i=0;i<100;i++) {
				pstmt.setString(1, "name"+i);
				pstmt.executeUpdate();
			}
			System.out.println("ʹ��PreparedStatement��ʱ:" + (System.currentTimeMillis() - start));
		}
	}
	public static void main(String[] args) throws Exception {
		PreparedStatementTest pt=new PreparedStatementTest();
		pt.initParam("mysql.ini");
		pt.insertUserStatement();
		pt.insertUserPrepare();
	}
}
