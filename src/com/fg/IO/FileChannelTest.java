package com.fg.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
	public static void main(String[] args) {
		File file=new File("mysql.ini");
		try (
			//����FileInputStream���Ը��ļ�����������FileChannel
				FileChannel inChannel=new FileInputStream(file).getChannel();
				//���ļ����������FileChannel,���Կ������
				FileChannel outChannel=new FileOutputStream("a.txt").getChannel();
			){
			//��FileChannel���ȫ������ӳ���ByteBuffer
			MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//ʹ��GBK���ַ���������������
			Charset charset=Charset.forName("utf-8");
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			//�ٴε���buffer��clear()����,��ԭlimit,position��λ��
			buffer.clear();
			//����������(CharsetDecoder)����
			CharsetDecoder decoder=charset.newDecoder();
			//ʹ�ý�������byteBufferת����CharBuffer
			CharBuffer charBuffer=decoder.decode(buffer);
			//CharBuffer��toString()�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
