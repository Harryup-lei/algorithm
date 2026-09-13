package com.kelei;

public class Lettcode402 {
	String ret;
	public String removeKdigits(String num, int k) {
		char[] arr = num.toCharArray();
		int n = arr.length;
		if(n <= k){
			return "0";
		}
		ret = num;
		StringBuilder sb = new StringBuilder(num);
		dfs(sb, k, 0);
		return ret;
	}
	void dfs(StringBuilder sb, int k, int cnt){
		if(cnt > k){
			return;
		}
		//回溯
		if(cnt == k){
			String cur = sb.toString();
			if (compare(cur, ret)) ret = strip(cur);
			return;
		}
		for(int i = 0; i < sb.length(); i++){
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			dfs(sb, k , cnt + 1);
			sb.insert(i, c);
		}
	}
	boolean compare(String s1, String s2){
		s1 = strip(s1); s2 = strip(s2);
		if (s1.length() != s2.length()) return s1.length() < s2.length();
		return s1.compareTo(s2) < 0;
	}
	String strip(String s) {
		int i = 0;
		while (i < s.length() - 1 && s.charAt(i) == '0') i++;
		return s.substring(i);
	}


}
