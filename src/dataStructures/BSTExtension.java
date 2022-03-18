package dataStructures;
import dataStructures.minPriorityQueue;

public class BSTExtension implements minPriorityQueue {
	private Node root;
	private Node min;
	
	private class Node{
		private int key;
		private Node left, right, p, succ;
		
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.p = null;
			this.succ = null;
		}
	}
	
	public BSTExtension() {
		root = null;
	}
	
	public void insert(int zKey) {
		Node y = null;
		Node x = root;
		Node z = new Node(zKey);
		
		// Check if the insert number is the new minimum
		if (min == null || zKey < min.key) {
			min = z;
		}
	
		// Find the space to insert x
		// and keep y as a pointer to the parent
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}else {
				x = x.right;
			}
		}
		
		// Insert the new node
		z.p = y;
		if (y == null) {
			root = z;
		}else if(z.key < y.key) {
			y.left = z;
		}else {
			y.right = z;
		}
		
		successorify(root, null);
		
	}
	
	public Node successorify(Node x, Node prev) {
		if (x != null) {
			prev = successorify(x.left, prev);
			if (prev != null) {
				prev.succ = x;
			}
			prev = x;
			prev = successorify(x.right, prev);
		}
		return prev;
	}
	
	public Node getMinNode(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	public int min() {
		if (min != null) {
			return min.key;
		}else {
			return -1;
		}
	}
	
	public int extractMin() {
		if (root == null) {
			return -1;
		}
		Node minNode = min;
		
		// Set the new minimum as the parent of the old minimum
		min = minNode.succ;
		transplant(minNode, minNode.right);
		
		return minNode.key;
	}
	
	public void transplant(Node u, Node v) {
		if (u.p == null) {
			root = v;
		}else if (u.equals(u.p.left)) {
			u.p.left = v;
		}else {
			u.p.right = v;
		}
		if (v != null) {
			v.p = u.p;
		}
	}
	
	public void delete(Node z) {
		if (z.left == null) {
			transplant(z, z.right);
		}else if (z.right == null) {
			transplant(z, z.left);
		} else {
			Node y = getMinNode(z.right);
			if (! y.p.equals(z)) {
				transplant(y,y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(z,y);
			y.left = z.left;
			y.left.p = y;
		}
		
	}

	
	public static void main(String args[]) {
		BSTExtension x = new BSTExtension();
		int[] test = {3,2,2,7,8,4};
		for (int i: test) {
			x.insert(i);
		}
		int extracted = x.extractMin();
		while (extracted != -1) {	
			System.out.println("Extracted "+extracted);
			extracted = x.extractMin();
		}
	}
}
