package com.fg.IO;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Orientation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int i;

	public static final Orientation HORIZONTAL=new Orientation(1);
	public static final Orientation VERTICAL=new Orientation(2);
	public Orientation(int i) {
		// TODO Auto-generated constructor stub
		this.i=i;
	}
	//为枚举类增加readResolve()方法
	private Object readResolve() throws ObjectStreamException{
		if(i==1) {return HORIZONTAL;}
		if(i==2) {return VERTICAL;}
		return null;
	}
}
