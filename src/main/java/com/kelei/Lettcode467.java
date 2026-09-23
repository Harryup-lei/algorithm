package com.kelei;

public class Lettcode467 {
	public int findSubstringInWraproundString(String s) {
		//将子字符串个数，转化为以某个字符结尾的合法字符串的最大长度
		int[] cnt = new int[26];
		int cur = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && (s.charAt(i) - s.charAt(i-1) == 1
					|| s.charAt(i-1) - s.charAt(i) == 25)) {
				cur++;                 // z→a 也连续（差为 25）
			} else {
				cur = 1;               // 段断开，重新开始
			}
			int idx = s.charAt(i) - 'a';
			cnt[idx] = Math.max(cnt[idx], cur);   // 只保留最长
		}
		int res = 0;
		for (int c : cnt) res += c;
		return res;
	}
}
