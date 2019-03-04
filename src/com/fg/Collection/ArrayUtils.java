package com.fg.Collection;

public class ArrayUtils {
	public static int Search(String[] players,String first) {
		for(int i=0;i<players.length;i++) {
			if(players[i]!=null&&players.equals(first)) {
				return i;
			}
		}
		return 0;
	}
}
