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
	JFrame jf=new JFrame("图片管理程序");
	private static String IMAGEPATH="J:\\HACHI ICHI v07\\";
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;
	//定义一个DefaultListMode对象
	private DefaultListModel<ImageHolder> imgModel=new DefaultListModel<>();
	private JList<ImageHolder> imgList=new JList<>(imgModel);
	private JTextField filePath=new JTextField(26);
	private JButton browserBtn=new JButton("...");
	private JButton uploadBtn=new JButton("上传");
	private JLabel imgLabel=new JLabel();
	//以当前路径创建文件选择器
	JFileChooser chooser=new JFileChooser(IMAGEPATH);
	//创建文件过滤器
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
			// 获取数据库连接
				Connection conn = DriverManager.getConnection(url, user, pass);
				//创建执行插入的PreoaredStatement对象
				//该对象执行插入后可以返回自动生成的主键
				insert=conn.prepareStatement("insert into img_table"+
				" values(null,?,?);",Statement.RETURN_GENERATED_KEYS
						);
				//创建两个PreparedStatement对象,用于查询指定图片,查询所有图片
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
		//初始化文件选择器
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("png");
		filter.addExtension("gif");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.png,*.gif)");
		chooser.addChoosableFileFilter(filter);
		//禁止"文件类型" 下拉列表中显式"所有文件" 选项
		chooser.setAcceptAllFileFilterUsed(false);
		//初始化程序界面
		fillListModel();
		filePath.setEditable(false);
		//只能单选
		imgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp=new JPanel();
		jp.add(filePath);
		jp.add(browserBtn);
		browserBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//显式文本框
				int result=chooser.showDialog(jf, "浏览图片文件上传");
				//如果用户选择了OK按钮,即打开,保存等效按钮
				if(result==JFileChooser.APPROVE_OPTION) {
					filePath.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		jp.add(uploadBtn);
		uploadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//如果上传文件的文本框有内容
				if(filePath.getText().trim().length()>0) {
					//将指定文件保存到数据库
					upload(filePath.getText());
					//清空文本框内容
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
				//如果双击鼠标
				if(e.getClickCount()>=2) {
					System.out.println(e.getClickCount());
					//取出选中的List项
					ImageHolder cur=(ImageHolder)imgList.getSelectedValue();
					try{
						//显式选中项对应的Image
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
	 * 根据图片ID来显式图片
	 * @param id
	 * @throws SQLException
	 */
	public void showImage(int id) throws SQLException{
		//设置参数
		query.setInt(1, id);
		try(
			//执行查询
				ResultSet rs=query.executeQuery();
			){
			if(rs.next()) {
				//取出Blob列
				Blob imgBlob=rs.getBlob(1);
				//取出Blob列里的数据
				ImageIcon icon=new ImageIcon(imgBlob.getBytes(1L, (int)imgBlob.length()));
				imgLabel.setIcon(icon);
			}
		}
	}
	/**
	 * 将制定图片放入数据库
	 * @param text
	 */
	public  void upload(String fileName) {
		//截取文件名
		String imgName=fileName.substring(fileName.lastIndexOf("\\")+1, fileName.lastIndexOf("."));
		File f=new File(fileName);
		try(
				InputStream is=new FileInputStream(f)){
			//设置图片参数
			insert.setString(1, imgName);
			//设置二进制流参数
			insert.setBinaryStream(2, is,(int)f.length());
			int offset=insert.executeUpdate();
			if(offset==1) {
				//重新更新ListModel,让JFlist显式最新的图片列表
				fillListModel();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查找img_table表填充ListModel
	 * @throws SQLException 
	 */
	public void fillListModel() throws SQLException {
		try(
			//执行查询
			ResultSet rs=queryAll.executeQuery()
			){
			//先清除所有元素
			imgModel.clear();
			//把查询的记录全部添加到ListModel中
			while(rs.next()) {
				imgModel.addElement(new ImageHolder(rs.getInt(1),rs.getString(2)));
			}
		}
	}
	public static void main(String[] args) throws Exception {
		new BlobTest().init();
	}
}
//创建FileFilter的子类,用以实现文件过滤功能
class ExtensionFileFilter extends FileFilter{
	private String description="";
	private ArrayList<String> extensions=new ArrayList<>();
	//自定义方法,用于添加文件扩展名
	public void addExtension(String extension) {
		if(!extension.startsWith("."))
		{
			extension="."+extension;
			extensions.add(extension.toLowerCase());
		}
	}
	//用于设置该文件过滤器的描述文件
	public void setDescription(String aDescription) {
		description=aDescription;
	}
	//继承FileFilter类必须实现的抽象方法,判断该文件过滤器是否接受该文件
	@Override
	public boolean accept(File f) {
		//如果该文件是路径,则接受该文件
		if(f.isDirectory())return true;
		//将文件名转为小写(全部转为小写后比较,用于忽略文件名大小写)
		String name=f.getName().toLowerCase();
		//遍历所有可接受的扩展名,如果扩展名相同,则该文件就可接受
		for(String extension:extensions) {
			if(name.endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
	//继承FileFilter类必须实现的方法,返回该文件过滤器的描述文件
	@Override
	public String getDescription() {
		return description;
	}
}
//创建一个ImageHolder类,用于封装图片名和id
class ImageHolder{
	//封装图片的id
	private int id;
	//封装图片的名字
	private String name;
	public ImageHolder() {};
	public ImageHolder(int id,String name) {
		this.id=id;
		this.name=name;
	}
	//id和name的setter()和getter()方法
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
	//重写toString()方法,返回图片名
	public String toString() {
		return name;
	}
}
