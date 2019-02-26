package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetPage {
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
	public CachedRowSet query(String sql,int pageSize,int page) throws Exception{
		try(
			//��ȡ���ݿ�����
				Connection conn=DriverManager.getConnection(url, user, pass);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql)
			){
			//ʹ��RowSetProvider����RowSetFactory
			RowSetFactory factory=RowSetProvider.newFactory();
			//����Ĭ�ϵ�CachedRowSetʵ��
			CachedRowSet cachedRs=factory.createCachedRowSet();
			//����ÿҳ��ʾpageSize����¼
			cachedRs.setPageSize(pageSize);
			//ʹ��ResultSetװ��RowSet,���ôӵڼ�����¼��ʼ
			cachedRs.populate(rs, (page-1)*pageSize+1);
			return cachedRs;
			
		}
	}
	public static void main(String[] args) throws Exception {
		CachedRowSetPage cp=new CachedRowSetPage();
		cp.initParam("mysql.ini");
		CachedRowSet rs=cp.query("select * from student_table1", 3, 2);
		//�����������
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"
					+rs.getString(2)+"\t"+
					rs.getString(3));
		}
	}
}
