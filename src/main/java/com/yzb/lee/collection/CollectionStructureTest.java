package com.yzb.lee.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionStructureTest
{

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args)
	{
		List arraylist = new ArrayList();			// ArrayList底层是Object数组
		List vector = new Vector();					// Vector底层是Object数组,线程安全(方法上加了synchronized)
		List linkedList = new LinkedList();			// 带头尾的双向链表
		
		Set hashSet = new HashSet();				// HashSet底层就是HashMap实现，key存元素， value存Object
		SortedSet sortedSet = new TreeSet();		// TreeSet底层就是TreeMap实现
		Set linkedHashSet = new LinkedHashSet();	// LinkedHashSet继承HashSet
		
		Map hashMap = new HashMap();				// HashMap底层是hash表，数组元素是单向链表
		Map hashTable = new Hashtable();			// Hashtable底层是hash表，线程安全(方法上加了synchronized)
		SortedMap sortedMap = new TreeMap();		// TreeMap底层是红黑树
	}

}
