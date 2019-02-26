package com.fg.IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteTeacher {
	public static void main(String[] args) {
		try (
			//创建一个ObjectOutputStream输出流对象
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("teacher.txt"))
			){
			Person per=new Person("范闲", 16);
			Teacher t1=new Teacher("五竹叔", per);
			Teacher t2=new Teacher("海棠朵朵", per);
			//依次将4个对象写入输出流
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(per);
			oos.writeObject(t2);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
