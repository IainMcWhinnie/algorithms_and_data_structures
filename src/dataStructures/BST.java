package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BST {
	private Node root;
	
	private class Node{
		private int key;
		private Node left, right, p;
		private int size;
		
		public Node(int key, int size) {
			this.key = key;
			this.size = size;
			
			this.left = null;
			this.right = null;
			this.p = null;
		}
	}
	
	public BST() {
		root = null;
	}
	
	public void insert(int zKey) {
		Node y = null;
		Node x = root;
		Node z = new Node(zKey, 1);
		
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			}else {
				x = x.right;
			}
		}
		z.p = y;
		if (y == null) {
			root = z;
		}else if(z.key < y.key) {
			y.left = z;
		}else {
			y.right = z;
		}
	}
	
	public Node search(Node x, int k) {
		if (x == null || k == x.key) {
			return x;
		}
		if (k < x.key) {
			return search(x.left, k);
		}else {
			return search(x.right, k);
		}
	}
	
	public Node min(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
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
			Node y = min(z.right);
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
	
	public int[] inOrder() {
		List<Integer> result = new ArrayList<>();
		
		
		return  result.toArray(new int[result.size()]);
	}
	
	
	public static void main(String args[]) {
		BST x = new BST();
		int[] test = {1,4,2,6,3,7,5,8};
		for (int i: test) {
			x.insert(i);
		}
	}
}
