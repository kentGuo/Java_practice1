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
	public CachedRowSet query(String sql) throws Exception{
		//获取数据库连接
		Connection conn=DriverManager.getConnection(url, user, pass);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		//使用RowSetProvider创建RowSetFactory
		RowSetFactory factory=RowSetProvider.newFactory();
		//创建默认的CachedRowSet实例
		CachedRowSet cachedRs=factory.createCachedRowSet();
		//使用ResultSet装填RowSet
		cachedRs.populate(rs);
		//关闭资源
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
		//向前滚动结果集
		while(rs.previous()) {
			System.out.println(rs.getString(1)+"\t"
		+rs.getString(2)+"\t"+
		rs.getString(3));
			if(rs.getInt("student_id")==4) {
				//修改指定记录行
				rs.updateString("student_name", "KKKK");
				rs.updateRow();
			}
		}
		//重新获取数据库连接
		Connection conn=DriverManager.getConnection(ct.url, ct.user, ct.pass);
	conn.setAutoCommit(false);
	//把对RowSet所做的修改同步到底层数据列
	rs.acceptChanges(conn);
	}
}
