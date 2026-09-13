package com.kelei;

public class Lettcode419 {
	int m, n;
	public int countBattleships(char[][] board) {
		m = board.length;
		n = board[0].length;
		int ret = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == 'X'){
					dfs(board, i, j);
					ret++;
				}
			}
		}
		return ret;
	}
	void dfs(char[][] board, int i, int j){
		if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '.'){
			return;
		}
		board[i][j] = '.';
		dfs(board, i - 1, j);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
		dfs(board, i, j + 1);
	}
}
