package com.kelei;

public class Lettcode430_1 {
	private Node prevNode = new Node(0);

	public Node flatten(Node head) {
		dfs(head);
		if (head != null) {
			head.prev = null;
		}
		return head;
	}

	private void dfs(Node root) {
		if (root == null) {
			return;
		}
		Node left = root.child;
		Node right = root.next;
		prevNode.next = root;
		root.prev = prevNode;
		prevNode = root;
		dfs(left);
		root.child = null;
		dfs(right);
	}
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node(int i) {
			this.val = i;
		}
	};
}

