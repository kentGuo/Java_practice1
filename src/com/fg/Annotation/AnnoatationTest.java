package com.fg.Annotation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnoatationTest {
	private JFrame mainWin=new JFrame("ʹ��ע�Ͱ��¼�������");
	//ʹ��AnnotationΪok��ť���¼�������
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok=new JButton("ȷ��");
	//ʹ��AnnotationΪcancel��ť���¼�������
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel=new JButton("ȡ��");
	private void init() {
		//��ʼ������ķ���
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
//����ok��ť��ʱ�������ʵ����
class OkListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "������ȷ�ϰ�ť");
	}
	
}
//����cancel��ť���¼�������ʵ����
class CancelListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "������ȡ����ť");
	}
	
}
