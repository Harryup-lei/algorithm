package com.kelei;

import java.util.ArrayList;
import java.util.List;

public class Lettcode417 {
	/**
	 * 采用深度优先搜索遍历 O((m * n) ^ 2)
	 */
	int m, n;
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> ret = new ArrayList<>();

		m = heights.length;
		n = heights[0].length;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				boolean[] target = new boolean[2];
				dfs(heights, i, j, new boolean[m][n], target, Integer.MAX_VALUE);
				if(target[0] && target[1]){
					ret.add(new ArrayList<Integer>(List.of(i, j)));
				}
			}
		}
		return ret;
	}
	void dfs(int[][] heights, int i, int j, boolean[][] b, boolean[] target, int pre){
		if(i < 0 || i >= m || j < 0 || j >= n || b[i][j]){
			return;
		}
		if(heights[i][j] > pre){
			return;
		}
		if(i == 0 || j == 0){
			target[0] = true;
		}
		if(i == m - 1 || j == n - 1){
			target[1] = true;
		}
		b[i][j] = true;
		dfs(heights, i - 1, j, b, target, heights[i][j]);
		dfs(heights, i, j - 1, b, target, heights[i][j]);
		dfs(heights, i, j + 1, b, target, heights[i][j]);
		dfs(heights, i + 1, j, b, target, heights[i][j]);
	}
}
