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
		// 使用properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
		// 加载驱动
		Class.forName(driver);
	}
	public void info() throws Exception{
		try(
			Connection conn=DriverManager.getConnection(url, user, pass)
			){
			//获取DatabaseMetaData对象
			DatabaseMetaData dbmd=conn.getMetaData();
			//获取MySQL支持的所有表类型
			ResultSet rs=dbmd.getTableTypes();
			System.out.println("MySQL支持的表类型信息");
			printResultSet(rs);
			//获取student_table表的主键
			rs=dbmd.getPrimaryKeys(null, null, "student_table");
			System.out.println("student_table表的主键信息");
			printResultSet(rs);
			//获取当前数据库的全部存储过程
			rs=dbmd.getProcedures(null, null, "%");
			System.out.println("当前数据库里的存储过程信息");
			printResultSet(rs);
			//获取teacher_table表和student_table表之间的外键约束
			rs=dbmd.getCrossReference(null, null, "teacher_table", null, null, "student_table");
			System.out.println("teacher_table表和student_table表之间的外键约束");
			printResultSet(rs);
			//获取student_table表的全部数据列
			rs=dbmd.getColumns(null, null, "student_table","%");
			System.out.println("student_table表的全部数据列");
			printResultSet(rs);
		}
	}
	public void printResultSet(ResultSet rs) throws Exception {
		ResultSetMetaData rsmd=rs.getMetaData();
		//打印ResultSet的所有列标题
		for(int i=0;i<rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i+1)+"\t");
		}
		System.out.println("\n");
		//打印ResultSet里的全部数据
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
