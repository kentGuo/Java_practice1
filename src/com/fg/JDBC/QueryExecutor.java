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
	JFrame jf=new JFrame("��ѯִ����");
	private JScrollPane scrollPane;
	private JButton execBtn=new JButton("��ѯ");
	//���������ѯ�����ı���
	private JTextField sqlField=new JTextField(45);
	private static Connection conn;
	private static Statement stmt;
	//���þ�̬��ʼ������ʼ��Connection,Statement����
	static {
		try {
			Properties p=new Properties();
			p.load(new FileInputStream("mysql.ini"));
			String driver=p.getProperty("driver");
			 String url=p.getProperty("url");
			 String user=p.getProperty("user");
			 String pass=p.getProperty("pass");
			 //�������ݿ�����
			 Class.forName(driver);
			 //ȡ�����ݿ�����
			 conn=DriverManager.getConnection(url,user,pass);
			 stmt=conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void init() {
		JPanel top=new JPanel();
		top.add(new JLabel("�����ѯ���"));
		top.add(sqlField);
		top.add(execBtn,BorderLayout.EAST);
		//Ϊִ�а�ť,�����ı�������¼�������
		execBtn.addActionListener(new ExceListener());
		sqlField.addActionListener(new ExceListener());
		jf.add(top,BorderLayout.NORTH);
		jf.setSize(640, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	//���������
	class ExceListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//ɾ��ԭ����Jtable(JTableʹ��scrollPane����װ)
			if(scrollPane!=null)
			{
				jf.remove(scrollPane);
			}
			try(
				//�����û������SQL���ִ�в�ѯ
				ResultSet rs=stmt.executeQuery(sqlField.getText());
				){
				//ȡ��ResultSet��MetaData
				ResultSetMetaData rsmd=rs.getMetaData();
				Vector<String> columnNames=new Vector<>();
				Vector<Vector<String>> data=new Vector<>();
				//��ResultSet������������ӵ�Vector��
				for(int i=0;i<rsmd.getColumnCount();i++) {
					columnNames.add(rsmd.getColumnName(i+1));
				}
				//��ResultSet�����м�¼��ӵ�Vector��
				while(rs.next()) {
					Vector<String> v=new Vector<>();
					for(int i=0;i<rsmd.getColumnCount();i++) {
						v.add(rs.getString(i+1));
					}
					data.add(v);
				}
				//�����µ�Jtable
				JTable table=new JTable(data,columnNames);
				scrollPane=new JScrollPane(table);
				//����µ�Table
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

