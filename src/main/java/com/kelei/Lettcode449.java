package com.kelei;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lettcode449 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v){
			this.val = v;
		}
	}
	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		dfs(root, list);
		return String.join(",", list);
	}
	void dfs(TreeNode root, List<String> list){
		if(root == null) return;
		list.add(String.valueOf(root.val));
		dfs(root.left, list);
		dfs(root.right, list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.isEmpty()){
			return null;
		}
		String[] str = data.split(",");
		Deque<Integer> dq = new ArrayDeque<>();
		for(String s : str){
			dq.offer(Integer.parseInt(s));
		}
		return build(dq, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	TreeNode build(Deque<Integer> dq, int min, int max){
		if(dq.size() == 0) return null;
		int x = dq.peek();
		if(x < min || x > max){
			return null;
		}
		dq.poll();
		TreeNode root = new TreeNode(x);
		root.left = build(dq, min, x);
		root.right = build(dq, x, max);
		return root;
	}
	// TreeNode build(String[] str, int l, int r){
	//     if(l > r){
	//         return null;
	//     }
	//     int mid = l + (r - l) / 2;
	//     TreeNode root = new TreeNode(Integer.parseInt(str[mid]));
	//     root.left = build(str, l, mid - 1);
	//     root.right = build(str, mid + 1, r);
	//     return root;
	// }
}
