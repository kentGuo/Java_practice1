package com.fg.Collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationTest {
		public static void main(String[] args) {
			Vector<Object> v=new Vector<>();
			v.add("庆余年");
			v.add("恶魔法则");
			v.add("陈二狗的妖虐人生");
			Hashtable<Object, Object> scores=new Hashtable<>();
			scores.put("语文", 78);
			scores.put("数学", 88);
			Enumeration<Object> em=v.elements();
			while(em.hasMoreElements()) {
				System.out.println(em.nextElement());
			}
			Enumeration<Object> keyEm=scores.keys();
			while(keyEm.hasMoreElements()) {
				Object key=keyEm.nextElement();
				System.out.println(key+"--->"+scores.get(key));
			}
		}
}
