package com.fg.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SynchroniedTest {
	public static void main(String[] args) {
		//下面程序创建了4个同步的集合对象
		Collection<Object> c=Collections.synchronizedCollection(new ArrayList<>());
		List<Object> list=Collections.synchronizedList(new ArrayList<>());
		Set<Object> s=Collections.synchronizedSet(new HashSet<>());
		Map<Object, Object> m=Collections.synchronizedMap(new HashMap<Object, Object>());
	}
}
