package com.kelei;

public class Lettcode402_1 {
	//单调栈的写法
	public String removeKdigits(String num, int k) {
		if(num.length() <= k)       return "0";

		StringBuilder stack = new StringBuilder();
		int remains = num.length() - k;

		for(int i = 0; i < num.length(); i++){
			char ch = num.charAt(i);
			while(k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > ch){
				stack.setLength(stack.length() - 1);
				k--;
			}
			if(ch == '0' && stack.length() == 0){
				continue;
			}
			stack.append(ch);
		}
		if (k > 0) {
			stack.setLength(Math.max(0, stack.length() - k));
		}
		return stack.length() == 0 ? "0" : stack.toString();
	}
	//比较的方法
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
