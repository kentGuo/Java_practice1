package com.fg.JDBC;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame {
	private final String PROP_FILE="mysql.ini";
	private String driver;
	//url是数据库的服务地址
	private String url;
	private String user;
	private String pass;
	//登录界面的GUI组件
	private JFrame jf=new JFrame("登录");
	private JTextField userField=new JTextField(20);
	private JTextField passField=new JTextField(20);
	private JButton loginBtn=new JButton("登录");
	public void init() throws Exception{
		Properties connPop=new Properties();
		connPop.load(new FileInputStream(PROP_FILE));
		driver=connPop.getProperty("driver");
		url=connPop.getProperty("url");
		user=connPop.getProperty("user");
		pass=connPop.getProperty("pass");
		//加载驱动
		Class.forName(driver);
		//为登录按钮添加事件监听器
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//登录成功则显示"登录成功"
				if(validate(userField.getText(), passField.getText())) {
					JOptionPane.showMessageDialog(jf, "登录成功");
					userField.setText("");
					passField.setText("");
				}else {
					//否则显示"登录失败"
					JOptionPane.showMessageDialog(jf, "登录失败");
					userField.setText("");
					passField.setText("");
				}
			}
		});
		jf.add(userField,BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginBtn,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	private boolean validate(String userName,String userPass) {
		//执行查询的SQL语句
		String sql="select * from jdbc_test "+
				"where jdbc_name='"+userName+
				"' and jdbc_desc='"+userPass+
				"'";
		System.out.println(sql);
		try(
			Connection conn=DriverManager.getConnection(url, user, pass);
			PreparedStatement psmt=conn.prepareStatement("select * from jdbc_test "+
					"where jdbc_name=?"+
					"and jdbc_desc=?");

			//ResultSet rs=psmt.executeQuery(sql);
				){
			
			psmt.setString(1, userName);
			psmt.setString(2, userPass);
			try(
					ResultSet rs=psmt.executeQuery()
			//如果查询的ResultSet里有超过一条的记录,则登录成功
					){
				if(rs.next())
				{
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		new LoginFrame().init();;
	}
}
