package com.kelei;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lettcode456 {
	public boolean find132pattern(int[] nums) {
		int n = nums.length;
		Deque<Integer> dq = new ArrayDeque<>();
		int k = Integer.MIN_VALUE;
		for(int i = n - 1; i >= 0; i--){
			if(nums[i] < k) return true;
			while(!dq.isEmpty() && dq.peekLast() < nums[i]){
				k = Math.max(k, dq.pollLast());
			}
			dq.offerLast(nums[i]);
		}
		return false;
	}
}
