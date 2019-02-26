package com.fg.JDBC;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QueryExecutor {
	JFrame jf=new JFrame("查询执行器");
	private JScrollPane scrollPane;
	private JButton execBtn=new JButton("查询");
	//用于输入查询语句的文本框
	private JTextField sqlField=new JTextField(45);
	private static Connection conn;
	private static Statement stmt;
	//采用静态初始化来初始化Connection,Statement对象
	static {
		try {
			Properties p=new Properties();
			p.load(new FileInputStream("mysql.ini"));
			String driver=p.getProperty("driver");
			 String url=p.getProperty("url");
			 String user=p.getProperty("user");
			 String pass=p.getProperty("pass");
			 //加载数据库驱动
			 Class.forName(driver);
			 //取得数据库连接
			 conn=DriverManager.getConnection(url,user,pass);
			 stmt=conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void init() {
		JPanel top=new JPanel();
		top.add(new JLabel("输入查询语句"));
		top.add(sqlField);
		top.add(execBtn,BorderLayout.EAST);
		//为执行按钮,单行文本框添加事件监听器
		execBtn.addActionListener(new ExceListener());
		sqlField.addActionListener(new ExceListener());
		jf.add(top,BorderLayout.NORTH);
		jf.setSize(640, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	//定义监听器
	class ExceListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//删除原来的Jtable(JTable使用scrollPane来包装)
			if(scrollPane!=null)
			{
				jf.remove(scrollPane);
			}
			try(
				//根据用户输入的SQL语句执行查询
				ResultSet rs=stmt.executeQuery(sqlField.getText());
				){
				//取出ResultSet的MetaData
				ResultSetMetaData rsmd=rs.getMetaData();
				Vector<String> columnNames=new Vector<>();
				Vector<Vector<String>> data=new Vector<>();
				//把ResultSet的所有列名添加到Vector里
				for(int i=0;i<rsmd.getColumnCount();i++) {
					columnNames.add(rsmd.getColumnName(i+1));
				}
				//把ResultSet的所有记录添加到Vector里
				while(rs.next()) {
					Vector<String> v=new Vector<>();
					for(int i=0;i<rsmd.getColumnCount();i++) {
						v.add(rs.getString(i+1));
					}
					data.add(v);
				}
				//创建新的Jtable
				JTable table=new JTable(data,columnNames);
				scrollPane=new JScrollPane(table);
				//添加新的Table
				jf.add(scrollPane);
				jf.validate();
				
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}}
	public static void main(String[] args) {
		new QueryExecutor().init();
	}

}

