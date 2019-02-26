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
			//创建FileInputStream，以该文件输入流创建FileChannel
				FileChannel inChannel=new FileInputStream(file).getChannel();
				//以文件输出流控制FileChannel,用以控制输出
				FileChannel outChannel=new FileOutputStream("a.txt").getChannel();
			){
			//将FileChannel里的全部数据映射成ByteBuffer
			MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//使用GBK的字符集来创建解码器
			Charset charset=Charset.forName("utf-8");
			//直接将buffer里的数据全部输出
			outChannel.write(buffer);
			//再次调用buffer的clear()方法,复原limit,position的位置
			buffer.clear();
			//创建解码器(CharsetDecoder)对象
			CharsetDecoder decoder=charset.newDecoder();
			//使用解码器将byteBuffer转换成CharBuffer
			CharBuffer charBuffer=decoder.decode(buffer);
			//CharBuffer的toString()方法可以获取对应的字符串
			System.out.println(charBuffer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
