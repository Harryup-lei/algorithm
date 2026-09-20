package com.kelei;
import java.util.Arrays;

public class Lettcode462 {
	public int minMoves2(int[] nums) {
		//先找数组数的中位数,在进行处理
		int n = nums.length;
		if(n == 1){
			return 0;
		}else if(n == 2){
			return Math.max(nums[0], nums[1]) - Math.min(nums[0], nums[1]);
		}
		Arrays.sort(nums);
		int middle = nums[n / 2];
		int ans = 0;
		for (int x : nums) {
			ans += Math.abs(x - middle);
		}
		return ans;
	}
}
