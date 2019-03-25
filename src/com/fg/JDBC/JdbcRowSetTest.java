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
		// 使用properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
		//加载驱动
		Class.forName(driver);
	}
	public void update(String sql) throws Exception{
		try(
			//获取数据库连接
				Connection conn=DriverManager.getConnection(url, user, pass);
				//创建JdbcRowSetImpl对象
			//	JdbcRowSet jdbcRs=new JdbcRowSetImpl(conn)
			){}
	}
}
