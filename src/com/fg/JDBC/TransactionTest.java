package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {
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
	public void insertTransaction(String[] sqls,String sqlt) throws Exception{
		try(
			Connection conn=DriverManager.getConnection(url, user, pass);
			){
			//保存当前的自动提交模式
			boolean autoCommit=conn.getAutoCommit();
			//关闭自动提交，开启事务
			conn.setAutoCommit(false);
			try(
				//使用Connection来创建一个Statement对象
				Statement stmt=conn.createStatement();
				){
				//循环多次执行SQL语句
				for(String sql:sqls) {
					stmt.addBatch(sql);
				}
				//同时执行所有的SQL语句
				int[] count=stmt.executeBatch();
				System.out.println("共有"+count.length+"条SQL语句");
				ResultSet rs=stmt.executeQuery(sqlt);
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+
							rs.getString(2)+"\t"
							+rs.getString(3));
				}
			}
			//提交事务
			conn.commit();
			//恢复原有的自动提交模式
			conn.setAutoCommit(autoCommit);
		}
	}
	public static void main(String[] args) throws Exception {
		TransactionTest tt=new TransactionTest();
		tt.initParam("mysql.ini");
		String[] sqls=new String[] {
				"insert into student_table VALUES(null,'aaa',1);",
				"insert into student_table VALUES(null,'bbb',1);",
				"insert into student_table VALUES(null,'ccc',1);",
				"delete from student_table where java_teacher=1",
				//不能使用select语句,下面会出现异常
				//"select * from student_table;",
				//下面这条SQL语句将会违反外键约束
				//因为teacher_table表中没有ID为5的记录。
				"insert into student_table VALUES(null,'ddd',8);"
		};
		String sqlt="select * from student_table;";
		tt.insertTransaction(sqls,sqlt);
	}
}
