package com.kelei;

import java.util.Arrays;

public class Lettcode475 {
	public int findRadius(int[] houses, int[] heaters) {
		//两边最小，全局取最大
		Arrays.sort(heaters);
		int m = houses.length;
		int n = heaters.length;
		int max = 0;
		for(int k = 0; k < m; k++){
			int target = houses[k];
			int left = findLeft(heaters, target);
			int right = findRight(heaters, target);
			if(left == n){
				max = Math.max(Math.abs(heaters[n - 1] - target), max);
			}else if(right == -1){
				max = Math.max(Math.abs(heaters[0] - target), max);
			}else{
				int min = Math.min(Math.abs(heaters[left] - target), Math.abs(heaters[right] - target));
				max = Math.max(min, max);
			}
		}
		return max;
	}
	int findLeft(int[] heaters, int target){
		int i = 0;
		int n = heaters.length;
		int j = n - 1;
		int ans = n;
		while(i <= j){
			int mid = i + (j - i) / 2;
			if(heaters[mid] >= target){
				ans = mid;
				j = mid - 1;
			}else{
				i = mid + 1;
			}
		}
		return ans;
	}
	int findRight(int[] heaters, int target){
		int i = 0;
		int n = heaters.length;
		int j = n - 1;
		int ans = -1;
		while(i <= j){
			int mid = i + (j - i) / 2;
			if(heaters[mid] <= target){
				ans = mid;
				i = mid + 1;
			}else{
				j = mid - 1;
			}
		}
		return ans;
	}
}
