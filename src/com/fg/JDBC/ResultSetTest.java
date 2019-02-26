package com.fg.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ResultSetTest {
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
	}

	public void query(String sql) throws Exception {
		// ��������
		Class.forName(driver);
		try (
				// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
				// ʹ��Connection������һ��PreoaredStatement����
				//������ƽ�����ɹ���,�ɸ��µĲ���
				PreparedStatement pstmt=conn.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=pstmt.executeQuery())
		{
			rs.last();
			int rowCount=rs.getRow();
			for(int i=rowCount;i>0;i--) {
				rs.absolute(i);
				System.out.println(rs.getString(1)+"\t"
						+rs.getString(2)+"\t"
						+rs.getString(3));
				//�޸ļ�¼ָ����ָ��¼,��2�е�ֵ
				rs.updateString(2, "ѧ����"+i);
				//�ύ�޸�
				rs.updateRow();
			}

		}
	}
	public static void main(String[] args) throws Exception {
		ResultSetTest rt=new ResultSetTest();
		rt.initParam("mysql.ini");
		rt.query("select * from student_table1");
	}
}