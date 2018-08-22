package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;


public class DatabaseMetaDataTest {
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
	public void info() throws Exception{
		try(
			Connection conn=DriverManager.getConnection(url, user, pass)
			){
			//��ȡDatabaseMetaData����
			DatabaseMetaData dbmd=conn.getMetaData();
			//��ȡMySQL֧�ֵ����б�����
			ResultSet rs=dbmd.getTableTypes();
			System.out.println("MySQL֧�ֵı�������Ϣ");
			printResultSet(rs);
			//��ȡstudent_table�������
			rs=dbmd.getPrimaryKeys(null, null, "student_table");
			System.out.println("student_table���������Ϣ");
			printResultSet(rs);
			//��ȡ��ǰ���ݿ��ȫ���洢����
			rs=dbmd.getProcedures(null, null, "%");
			System.out.println("��ǰ���ݿ���Ĵ洢������Ϣ");
			printResultSet(rs);
			//��ȡteacher_table���student_table��֮������Լ��
			rs=dbmd.getCrossReference(null, null, "teacher_table", null, null, "student_table");
			System.out.println("teacher_table���student_table��֮������Լ��");
			printResultSet(rs);
			//��ȡstudent_table���ȫ��������
			rs=dbmd.getColumns(null, null, "student_table","%");
			System.out.println("student_table���ȫ��������");
			printResultSet(rs);
		}
	}
	public void printResultSet(ResultSet rs) throws Exception {
		ResultSetMetaData rsmd=rs.getMetaData();
		//��ӡResultSet�������б���
		for(int i=0;i<rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i+1)+"\t");
		}
		System.out.println("\n");
		//��ӡResultSet���ȫ������
		while(rs.next()) {
			for(int i=0;i<rsmd.getColumnCount();i++) {
				System.out.println(rs.getString(i+1)+"\t");
			}
			System.out.println("\n");
		}
		rs.close();
		
	}
	public static void main(String[] args) throws Exception {
		DatabaseMetaDataTest dmt=new DatabaseMetaDataTest();
		dmt.initParam("mysql.ini");
		dmt.info();
	}
}
