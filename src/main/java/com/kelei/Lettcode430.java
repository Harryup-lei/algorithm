package com.kelei;

public class Lettcode430 {
	public Node flatten(Node head) {
		Node dummy = new Node();
		dummy.next = head;

		Node curr = head;
		return dfs(head);
	}
	// 把以 head 开头的整条链（含所有层级）拉平，返回链头
	Node dfs(Node head) {
		Node cur = head;
		while(cur != null){
			if(cur.child != null){
				Node nxt = cur.next;
				Node childHead = cur.child;
				dfs(cur.child);
				cur.child = null;

				//处理头节点链接问题
				cur.next = childHead;
				childHead.prev = cur;

				Node tail = childHead;         // ③ 找子链尾
				while (tail.next != null) tail = tail.next;

				if(nxt != null){
					tail.next = nxt;
					nxt.prev = tail;
				}
				// cur = nxt;
				cur = tail;
			}
			cur = cur.next;
		}
		return head;
	}
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};
}
