package com.sapient.ace.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValues {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Unix", 67);
		map.put("MAC", 26);

		LinkedHashMap<String, Integer> lMap = SortMapByValues.sortMap_Value(map);
		System.out.println(lMap);

	}

	public static <K, V extends Comparable<V>> LinkedHashMap<K, V> sortMap_Value(
			HashMap<K, V> inputMap) {
		HashMap<K, V> unsortedMap = inputMap;
		LinkedHashMap<K, V> sortedMap = new LinkedHashMap<K, V>();
		Set<Map.Entry<K, V>> entrySet = unsortedMap.entrySet();

		List<Map.Entry<K, V>> entryList = new ArrayList<Map.Entry<K, V>>(
				entrySet);
		
		Collections.sort(entryList, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		for (Map.Entry<K, V> singleEntry : entryList) {
			sortedMap.put(singleEntry.getKey(), singleEntry.getValue());
		}

		return sortedMap;
	}
}
