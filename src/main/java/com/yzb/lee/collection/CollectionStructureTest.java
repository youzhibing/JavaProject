package com.yzb.lee.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
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
		List linkedList = new LinkedList();			// 带头尾的双向链表 Node<E>
		
		Set hashSet = new HashSet();				// HashSet底层就是HashMap实现，key存元素， value存Object
		SortedSet sortedSet = new TreeSet();		// TreeSet底层就是TreeMap实现
		Set linkedHashSet = new LinkedHashSet();	// LinkedHashSet继承HashSet
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();				// HashMap底层是hash表，数组元素是单向链表(不稳定性/无序性)
		Map hashTable = new Hashtable();											// Hashtable底层是hash表，线程安全(方法上加了synchronized)
		SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();		// TreeMap底层是红黑树(稳定性/有序性)
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();	// hashMap + LinkedList, 元素顺序是插入时的顺序 (稳定性/无序性)
		linkedHashMap.put("111", 123);
		linkedHashMap.put("110", 123);
		linkedHashMap.put("112", 123);
		linkedHashMap.put("aaa", 123);
		for (Entry<String, Integer> entry : linkedHashMap.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
