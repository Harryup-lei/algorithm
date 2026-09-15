package com.kelei;

import java.util.TreeMap;

public class Lettcode436 {
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		int[] res = new int[n];
		int idx = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < n; i++){
			map.put(intervals[i][0], i);
		}
		for(int i = 0; i < n; i++){
			int cnt = intervals[i][1];
			Integer key = map.ceilingKey(cnt);
			if(key == null){
				res[idx++] = -1;
			}else{
				res[idx++] = map.get(key);
			}
		}
		return res;
	}
}
