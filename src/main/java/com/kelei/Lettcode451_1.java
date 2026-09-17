package com.kelei;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Lettcode451_1 {
	class Solution {
		public String frequencySort(String s) {
			char[] cs = s.toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for (char c : cs) map.put(c, map.getOrDefault(c, 0) + 1);
			PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
				return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
			});
			for (char c : map.keySet()) q.add(new int[]{c, map.get(c)});
			StringBuilder sb = new StringBuilder();
			while (!q.isEmpty()) {
				int[] poll = q.poll();
				int c = poll[0], k = poll[1];
				while (k-- > 0) sb.append((char)(c));
			}
			return sb.toString();
		}
	}
}
