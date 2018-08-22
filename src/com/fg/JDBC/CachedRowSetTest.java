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

public class CachedRowSetTest {
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
	public CachedRowSet query(String sql) throws Exception{
		//��ȡ���ݿ�����
		Connection conn=DriverManager.getConnection(url, user, pass);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		//ʹ��RowSetProvider����RowSetFactory
		RowSetFactory factory=RowSetProvider.newFactory();
		//����Ĭ�ϵ�CachedRowSetʵ��
		CachedRowSet cachedRs=factory.createCachedRowSet();
		//ʹ��ResultSetװ��RowSet
		cachedRs.populate(rs);
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		return cachedRs;
	}
	public static void main(String[] args) throws Exception{
		CachedRowSetTest ct=new CachedRowSetTest();
		ct.initParam("mysql.ini");
		CachedRowSet rs=ct.query("select * from student_table2");
		rs.afterLast();
		//��ǰ���������
		while(rs.previous()) {
			System.out.println(rs.getString(1)+"\t"
		+rs.getString(2)+"\t"+
		rs.getString(3));
			if(rs.getInt("student_id")==4) {
				//�޸�ָ����¼��
				rs.updateString("student_name", "KKKK");
				rs.updateRow();
			}
		}
		//���»�ȡ���ݿ�����
		Connection conn=DriverManager.getConnection(ct.url, ct.user, ct.pass);
	conn.setAutoCommit(false);
	//�Ѷ�RowSet�������޸�ͬ�����ײ�������
	rs.acceptChanges(conn);
	}
}
