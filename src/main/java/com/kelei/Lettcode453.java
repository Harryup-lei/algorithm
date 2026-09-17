package com.kelei;

public class Lettcode453 {
	public int minMoves(int[] nums) {
		int sum = 0;
		int n = nums.length;
		int min = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++){
			min = Math.min(min, nums[i]);
		}
		for(int i = 0; i < n; i++){
			sum += nums[i] - min;
		}
		return sum;
	}
}
