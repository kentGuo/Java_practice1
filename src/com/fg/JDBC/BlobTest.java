package com.fg.JDBC;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;

public class BlobTest {
	JFrame jf=new JFrame("ͼƬ�������");
	private static String IMAGEPATH="J:\\HACHI ICHI v07\\";
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;
	//����һ��DefaultListMode����
	private DefaultListModel<ImageHolder> imgModel=new DefaultListModel<>();
	private JList<ImageHolder> imgList=new JList<>(imgModel);
	private JTextField filePath=new JTextField(26);
	private JButton browserBtn=new JButton("...");
	private JButton uploadBtn=new JButton("�ϴ�");
	private JLabel imgLabel=new JLabel();
	//�Ե�ǰ·�������ļ�ѡ����
	JFileChooser chooser=new JFileChooser(IMAGEPATH);
	//�����ļ�������
	ExtensionFileFilter filter=new ExtensionFileFilter();
	static {
		try {
			Properties properties=new Properties();
			properties.load(new FileInputStream("mysql.ini"));
			 String driver=properties.getProperty("driver");
			 String url=properties.getProperty("url");
			 String user=properties.getProperty("user");
			 String pass=properties.getProperty("pass");
			 Class.forName(driver);
			// ��ȡ���ݿ�����
				Connection conn = DriverManager.getConnection(url, user, pass);
				//����ִ�в����PreoaredStatement����
				//�ö���ִ�в������Է����Զ����ɵ�����
				insert=conn.prepareStatement("insert into img_table"+
				" values(null,?,?);",Statement.RETURN_GENERATED_KEYS
						);
				//��������PreparedStatement����,���ڲ�ѯָ��ͼƬ,��ѯ����ͼƬ
				query=conn.prepareStatement("select img_data from img_table"
						+" where img_id=?;");
				queryAll=conn.prepareStatement("select img_id,"+
						"img_name from img_table;");
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void init() throws SQLException{
		//��ʼ���ļ�ѡ����
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("png");
		filter.addExtension("gif");
		filter.setDescription("ͼƬ�ļ�(*.jpg,*.jpeg,*.png,*.gif)");
		chooser.addChoosableFileFilter(filter);
		//��ֹ"�ļ�����" �����б�����ʽ"�����ļ�" ѡ��
		chooser.setAcceptAllFileFilterUsed(false);
		//��ʼ���������
		fillListModel();
		filePath.setEditable(false);
		//ֻ�ܵ�ѡ
		imgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp=new JPanel();
		jp.add(filePath);
		jp.add(browserBtn);
		browserBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ʽ�ı���
				int result=chooser.showDialog(jf, "���ͼƬ�ļ��ϴ�");
				//����û�ѡ����OK��ť,����,�����Ч��ť
				if(result==JFileChooser.APPROVE_OPTION) {
					filePath.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		jp.add(uploadBtn);
		uploadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ϴ��ļ����ı���������
				if(filePath.getText().trim().length()>0) {
					//��ָ���ļ����浽���ݿ�
					upload(filePath.getText());
					//����ı�������
					filePath.setText("");
				}
			}

			
		});
		JPanel left=new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imgLabel),BorderLayout.CENTER);
		left.add(jp,BorderLayout.SOUTH);
		jf.add(left);
		imgList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imgList),BorderLayout.EAST);
		imgList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//���˫�����
				if(e.getClickCount()>=2) {
					System.out.println(e.getClickCount());
					//ȡ��ѡ�е�List��
					ImageHolder cur=(ImageHolder)imgList.getSelectedValue();
					try{
						//��ʽѡ�����Ӧ��Image
						showImage(cur.getId());
					}catch (SQLException ex) {
						ex.printStackTrace();
					}
					
				}
			}
			
		});
		jf.setSize(620, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	/**
	 * ����ͼƬID����ʽͼƬ
	 * @param id
	 * @throws SQLException
	 */
	public void showImage(int id) throws SQLException{
		//���ò���
		query.setInt(1, id);
		try(
			//ִ�в�ѯ
				ResultSet rs=query.executeQuery();
			){
			if(rs.next()) {
				//ȡ��Blob��
				Blob imgBlob=rs.getBlob(1);
				//ȡ��Blob���������
				ImageIcon icon=new ImageIcon(imgBlob.getBytes(1L, (int)imgBlob.length()));
				imgLabel.setIcon(icon);
			}
		}
	}
	/**
	 * ���ƶ�ͼƬ�������ݿ�
	 * @param text
	 */
	public  void upload(String fileName) {
		//��ȡ�ļ���
		String imgName=fileName.substring(fileName.lastIndexOf("\\")+1, fileName.lastIndexOf("."));
		File f=new File(fileName);
		try(
				InputStream is=new FileInputStream(f)){
			//����ͼƬ����
			insert.setString(1, imgName);
			//���ö�����������
			insert.setBinaryStream(2, is,(int)f.length());
			int offset=insert.executeUpdate();
			if(offset==1) {
				//���¸���ListModel,��JFlist��ʽ���µ�ͼƬ�б�
				fillListModel();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ����img_table�����ListModel
	 * @throws SQLException 
	 */
	public void fillListModel() throws SQLException {
		try(
			//ִ�в�ѯ
			ResultSet rs=queryAll.executeQuery()
			){
			//���������Ԫ��
			imgModel.clear();
			//�Ѳ�ѯ�ļ�¼ȫ����ӵ�ListModel��
			while(rs.next()) {
				imgModel.addElement(new ImageHolder(rs.getInt(1),rs.getString(2)));
			}
		}
	}
	public static void main(String[] args) throws Exception {
		new BlobTest().init();
	}
}
//����FileFilter������,����ʵ���ļ����˹���
class ExtensionFileFilter extends FileFilter{
	private String description="";
	private ArrayList<String> extensions=new ArrayList<>();
	//�Զ��巽��,��������ļ���չ��
	public void addExtension(String extension) {
		if(!extension.startsWith("."))
		{
			extension="."+extension;
			extensions.add(extension.toLowerCase());
		}
	}
	//�������ø��ļ��������������ļ�
	public void setDescription(String aDescription) {
		description=aDescription;
	}
	//�̳�FileFilter�����ʵ�ֵĳ��󷽷�,�жϸ��ļ��������Ƿ���ܸ��ļ�
	@Override
	public boolean accept(File f) {
		//������ļ���·��,����ܸ��ļ�
		if(f.isDirectory())return true;
		//���ļ���תΪСд(ȫ��תΪСд��Ƚ�,���ں����ļ�����Сд)
		String name=f.getName().toLowerCase();
		//�������пɽ��ܵ���չ��,�����չ����ͬ,����ļ��Ϳɽ���
		for(String extension:extensions) {
			if(name.endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
	//�̳�FileFilter�����ʵ�ֵķ���,���ظ��ļ��������������ļ�
	@Override
	public String getDescription() {
		return description;
	}
}
//����һ��ImageHolder��,���ڷ�װͼƬ����id
class ImageHolder{
	//��װͼƬ��id
	private int id;
	//��װͼƬ������
	private String name;
	public ImageHolder() {};
	public ImageHolder(int id,String name) {
		this.id=id;
		this.name=name;
	}
	//id��name��setter()��getter()����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//��дtoString()����,����ͼƬ��
	public String toString() {
		return name;
	}
}
