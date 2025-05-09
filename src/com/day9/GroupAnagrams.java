package com.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();

		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = solution.groupAnagrams(input);
		for (List<String> group : result) {
			System.out.print(group);
		}

	}

}
