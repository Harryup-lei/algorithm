package com.kelei;

import java.util.*;

public class Lettcode433 {
	static char[] items = new char[]{'A', 'C', 'G', 'T'};
	public int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> set = new HashSet<>();
		for (String s : bank) set.add(s);
		Deque<String> d = new ArrayDeque<>();
		Map<String, Integer> map = new HashMap<>();

		d.offer(startGene);
		map.put(startGene, 0);
		while(!d.isEmpty()){
			int size = d.size();
			while(size-- > 0){
				String s = d.poll();
				char[] cs = s.toCharArray();
				int step = map.get(s);
				for(int i = 0; i < 8; i++){
					char flag = cs[i];
					for(char c : items){
						if(cs[i] == c) continue;
						cs[i] = c;
						String sub = String.valueOf(cs);
						if(!set.contains(sub)){
							continue;
						}
						if(map.containsKey(sub)){
							continue;
						}
						if(sub.equals(endGene)){
							return step + 1;
						}
						map.put(sub, step + 1);
						d.offer(sub);
					}
					cs[i] = flag;
				}
			}
		}
		return -1;
	}
}
