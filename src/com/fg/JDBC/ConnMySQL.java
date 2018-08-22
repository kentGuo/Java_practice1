package com.fg.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySQL {
	public static void main(String[] args) {
		/**
		 * 1.��������,ʹ�÷���֪ʶ
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (
			/**
			 * 2.ʹ��DriverManager��ȡ���ݿ����� ���з��ص�Connection�ʹ�����Java��������ݿ�����
			 * ��ͬ���ݿ��URLд����Ҫ�������ĵ�,�û���,����
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javac", "root", "root");
			/**
			 * 3.ʹ��Connection������һ��Statement����
			 */
			Statement stmt = conn.createStatement();
			/**
			 * 4.ִ��SQL��� Statement������ִ��SQL���ķ���: (1) execute()��ִ���κ�SQL���-����һ��Boolean����
			 * ���ִ�к��һ�������ResultSet,�򷵻�true,���򷵻�false (2)executeQuery()ִ��select���-���ز�ѯ���Ľ����
			 * (3)executeUpdate()����ִ��DML���-����һ������ ����SQL���Ӱ��ļ�¼����
			 */
			ResultSet rs = stmt.executeQuery("select s.*,teacher_name" + " from student_table2 s,teacher_table2 t"
					+ " where t.teacher_id=s.java_teacher")){
			/**
			 * ResultSet��һϵ�е�getXXX(������|����)����,���ڻ�ȡ��¼ָ�� ָ����,�ض��е�ֵ,���ϵ�ʹ��next()����¼ָ������һ��
			 * ����ƶ�֮���¼ָ����Ȼָ����Ч��,��next()��������true
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
