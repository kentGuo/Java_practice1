package com.fg.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySQL {
	public static void main(String[] args) {
		/**
		 * 1.加载驱动,使用反射知识
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (
			/**
			 * 2.使用DriverManager获取数据库连接 其中返回的Connection就代表了Java程序和数据库连接
			 * 不同数据库的URL写法需要查驱动文档,用户名,密码
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javac", "root", "root");
			/**
			 * 3.使用Connection来创建一个Statement对象
			 */
			Statement stmt = conn.createStatement();
			/**
			 * 4.执行SQL语句 Statement有三种执行SQL语句的方法: (1) execute()可执行任何SQL语句-返回一个Boolean对象
			 * 如果执行后第一个结果是ResultSet,则返回true,否则返回false (2)executeQuery()执行select语句-返回查询到的结果集
			 * (3)executeUpdate()用于执行DML语句-返回一个整数 代表被SQL语句影响的记录条数
			 */
			ResultSet rs = stmt.executeQuery("select s.*,teacher_name" + " from student_table2 s,teacher_table2 t"
					+ " where t.teacher_id=s.java_teacher")){
			/**
			 * ResultSet有一系列的getXXX(列索引|列名)方法,用于获取记录指针 指向行,特定列的值,不断地使用next()将记录指针下移一行
			 * 如果移动之后记录指针依然指向有效行,则next()方法返回true
			 */
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
