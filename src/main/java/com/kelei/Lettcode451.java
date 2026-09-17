package com.kelei;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Lettcode451 {
	public String frequencySort(String s) {
		char[] ch = s.toCharArray();
		Map<Character, int[]> map = new HashMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for(char c : ch){
			if(c <= 'Z' && c >= 'A'){
				int[] array;
				if(map.containsKey(c)){
					array = map.get(c);
					array[1]++;
				}else{
					array = new int[2];
					array[0] = c - 'A' + 26;
					array[1]++;
					map.put(c, array);
				}
			}else if(c <= 'z' && c >= 'a'){
				int[] array;
				if(map.containsKey(c)){
					array = map.get(c);
					array[1]++;
				}else{
					array = new int[2];
					array[0] = c - 'a';
					array[1]++;
					map.put(c, array);
				}
			}else{
				int[] array;
				if(map.containsKey(c)){
					array = map.get(c);
					array[1]++;
				}else{
					array = new int[2];
					array[0] = c - '0' + 52;
					array[1]++;
					map.put(c, array);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int[] v : map.values()){
			pq.offer(v);
		}

		while(!pq.isEmpty()){
			int[] v = pq.poll();
			int size = v[1];
			char c;
			if(v[0] >= 0 && v[0] <= 25){
				c = (char)('a' + v[0]);
			}else if(v[0] >= 26 && v[0] <= 51){
				c = (char)('A' + v[0] - 26);
			}else{
				c = (char)('0' + v[0] - 52);
			}
			while(size-- > 0){
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
