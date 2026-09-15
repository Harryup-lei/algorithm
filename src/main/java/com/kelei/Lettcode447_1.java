package com.kelei;

import java.util.HashMap;
import java.util.Map;

public class Lettcode447_1 {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		int n = points.length;
		for(int i = 0; i < n; i++){
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
				int dist = x * x + y * y;
				map.put(dist, map.getOrDefault(dist, 0) + 1);
			}
			for (int dist : map.keySet()) {
				int cnt = map.get(dist);
				res += cnt * (cnt - 1);
			}
		}
		return res;
	}
}
