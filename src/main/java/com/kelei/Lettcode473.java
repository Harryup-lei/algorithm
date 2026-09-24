package com.kelei;

import java.util.Arrays;

public class Lettcode473 {
	public boolean makesquare(int[] matchsticks) {
		//找出4条相等的边,采用状态压缩加上记忆化的策略
		int sum = 0, avg, n = matchsticks.length;
		for (int stick : matchsticks) sum += stick;
		if (sum % 4 != 0) return false;
		Arrays.sort(matchsticks);

		int[] dp = new int[1<<n];
		Arrays.fill(dp, -1);
		return dfs(matchsticks, sum / 4, 0, dp, 0) == 1;
	}
	int dfs(int[] sticks, int avg, int curr, int[] dp, int state){
		if(dp[state] != -1){//记忆化
			return dp[state];
		}
		if(state == (1 << sticks.length) - 1) return dp[state] = 1;
		for(int i = 0; i < sticks.length; i++){
			if(((state >> i) & 1) == 0){//当前的未被选择
				int t = sticks[i];
				int x = curr + t;
				if(x == avg){
					if(dfs(sticks, avg, 0, dp, state | (1 << i)) == 1){
						dp[state | (1 << i)] = 1;
						dp[state] = 1;
						return 1;
					}
				}else if(x < avg){
					if(dfs(sticks, avg, x, dp, state | (1 << i)) == 1){
						dp[state | (1 << i)] = 1;
						dp[state] = 1;
						return 1;
					}
				}
			}
		}
		return dp[state] = 0;
	}
}
