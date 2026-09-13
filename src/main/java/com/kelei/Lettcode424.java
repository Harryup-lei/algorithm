package com.kelei;

public class Lettcode424 {
	public int characterReplacement(String s, int k) {
		int[] cnt = new int[26];
		int historyCharMax = 0;
		int l = 0, r = 0;
		char[] chars = s.toCharArray();
		for(r = 0; r < chars.length; r++){
			int idx = chars[r] - 'A';
			cnt[idx]++;
			historyCharMax = Math.max(historyCharMax, cnt[idx]);
			if(r - l + 1 > historyCharMax + k){
				cnt[chars[l] - 'A']--;
				l++;
			}
		}
		return chars.length - l;
	}
}
