package com.fg.Annotation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnoatationTest {
	private JFrame mainWin=new JFrame("使用注释绑定事件监听器");
	//使用Annotation为ok按钮绑定事件监听器
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok=new JButton("确认");
	//使用Annotation为cancel按钮绑定事件监听器
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel=new JButton("取消");
	private void init() {
		//初始化界面的方法
		JPanel jp=new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args) {
		new AnnoatationTest().init();
	}
	
}
//定义ok按钮的时间监听器实现类
class OkListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "单击了确认按钮");
	}
	
}
//定义cancel按钮的事件监听器实现类
class CancelListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "单击了取消按钮");
	}
	
}
