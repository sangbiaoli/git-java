package com.sangbill.test;

public class Abs {
	static final class Node {
		static final Node SHARED = new Node(1);
		public Node(int id) {
			this.id = id;
		}
		
		private int id;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
}
