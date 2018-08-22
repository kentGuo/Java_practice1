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
	//url�����ݿ�ķ����ַ
	private String url;
	private String user;
	private String pass;
	//��¼�����GUI���
	private JFrame jf=new JFrame("��¼");
	private JTextField userField=new JTextField(20);
	private JTextField passField=new JTextField(20);
	private JButton loginBtn=new JButton("��¼");
	public void init() throws Exception{
		Properties connPop=new Properties();
		connPop.load(new FileInputStream(PROP_FILE));
		driver=connPop.getProperty("driver");
		url=connPop.getProperty("url");
		user=connPop.getProperty("user");
		pass=connPop.getProperty("pass");
		//��������
		Class.forName(driver);
		//Ϊ��¼��ť����¼�������
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//��¼�ɹ�����ʾ"��¼�ɹ�"
				if(validate(userField.getText(), passField.getText())) {
					JOptionPane.showMessageDialog(jf, "��¼�ɹ�");
					userField.setText("");
					passField.setText("");
				}else {
					//������ʾ"��¼ʧ��"
					JOptionPane.showMessageDialog(jf, "��¼ʧ��");
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
		//ִ�в�ѯ��SQL���
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
			//�����ѯ��ResultSet���г���һ���ļ�¼,���¼�ɹ�
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
