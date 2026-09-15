package com.kelei;

import java.util.Arrays;

public class Lettcode436_1 {
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		int[][] startIdxs = new int[n][2];
		for(int i = 0; i < n; i++) {
			startIdxs[i][0] = intervals[i][0];
			startIdxs[i][1] = i;
		}
		Arrays.sort(startIdxs, (a, b) -> a[0] - b[0]);
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		for(int i = 0; i < n; i++) {
			int left = 0, right = n;
			while(left < right) {
				int mid = left + right >> 1;
				if(startIdxs[mid][0] < intervals[i][1]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			if(left < n) {
				ans[i] = startIdxs[left][1];
			}
		}
		return ans;
	}
}
