package com.yzb.lee.consistenthash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsTest
{
    
    public static void main(String[] args)
    {
        List<String> objs = new ArrayList<String>(5);
        List<String> synObjs = Collections.synchronizedList(objs);
        synObjs.add("hllo");
        System.out.println(objs);
        objs.clear();
        System.out.println(synObjs);
        
        Set<String> treeSet = new TreeSet<String>();
        LinkedList<String> users = null;
        
        HashSet hashSet = null;
        Hashtable table = null;
        
        Set<String> set = new TreeSet();
        TreeMap<String, Object> map = null;
        
    }
    
}
