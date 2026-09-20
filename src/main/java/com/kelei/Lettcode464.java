package com.kelei;

public class Lettcode464 {
	//博弈论
	int n, t;
	int[] f = new int[1 << 20];
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		n = maxChoosableInteger; t = desiredTotal;
		if(maxChoosableInteger >= desiredTotal){
			return true;
		}
		if(n * (n + 1) / 2 < desiredTotal){
			return false;
		}
		if(t == 0) return true;

		return dfs(0, 0) == 1;
	}
	int dfs(int state, int total){
		if(f[state] != 0){
			return f[state];
		}
		for(int i = 0; i < n; i++){
			if (((state >> i) & 1) == 1) continue;
			if(total + i + 1 >= t) return f[state] = 1;
			if(dfs((state | (1 << i)), total + i + 1) == -1) return f[state] = 1;
		}
		return f[state] = -1;
	}
}
