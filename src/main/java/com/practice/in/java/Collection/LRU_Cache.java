package com.practice.in.java.Collection;

import java.util.LinkedHashMap;
import java.util.Map;


//LRU Cache using LinkedHashMap
public class LRU_Cache {
	static int initialCapacity = 5;
	static float fillRatio = 0.75f;
	
	public static void main(String[]args) {
		CacheMap<String, String> dbCache = new CacheMap<>(4);
		dbCache.put("D", "DBLOGS");
		dbCache.put("N", "NetworkLogs");
		dbCache.put("E", "ErrorLogs");
		dbCache.put("U", "UserLogs");
		dbCache.get("E");
		dbCache.put("DL", "DailyLogs");
		dbCache.entrySet().stream().forEach(System.out::println);	
	}
	
}

class CacheMap<K,V> extends LinkedHashMap<K, V>{
	
	private static final long serialVersionUID = 1L;
	private int initialCapacity;
	
	public CacheMap(int capacity){
		super(capacity, 0.75f, true);
		this.initialCapacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return initialCapacity<this.size();
	}
}