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
	
	public int size(Node n) {
		 int size = 0;
		 
		 if (n.left != null) {
			 size += size(n.left);
		 }
		 if (n.right != null) {
			 size += size(n.right);
		 }
		 return size+1;	
	}
	
	public void inOrder(Node x) {
		if (x!= null) {
			inOrder(x.left);
			System.out.print(x.key);
			inOrder(x.right);
		}
	}
	
	public void preOrder(Node x) {
		if (x!= null) {
			System.out.print(x.key);
			inOrder(x.left);
			inOrder(x.right);
		}
	}

	public void postOrder(Node x) {
		if (x!= null) {
			inOrder(x.left);
			inOrder(x.right);
			System.out.print(x.key);
		}
	}
	
	public String level(Node[] nodes) {
		if (nodes.length == 0) {
			return "";
		}
		
		String out = "";
		int noNodes = 0;
		List<Node> children = new ArrayList<>();
		for (Node node: nodes) {
			
			if (node != null) {
				out += " "+Integer.toString(node.key)+" ";
				children.add(node.left);
				children.add(node.right);
				noNodes ++;
			}else {
				out += " ".repeat(3);
				children.add(null);
			}
		}
		if (noNodes == 0) {
			return "";
		}
		return out+"\n"+level(children.toArray(new Node[children.size()]));
	}
	
	public void print() {
		Node[] t = {root};
		System.out.println(level(t));
	}
	
	public boolean checkGreater(Node x, int value) {
		
	}
	
	public boolean checkLesser(Node x, int value) {
		
	}
	
	public boolean checkBST(Node x) {
		
		
		
		if (x.left != null && x.left.key > x.key) {
			return false;
		}
		if (x.right != null && x.right.key < x.key) {
			return false;
		}
		
		
		return true;
	}
	
	
	public static void main(String args[]) {
		BST x = new BST();
		int[] test = {5,4,6,7,1,2,3,8};
		for (int i: test) {
			x.insert(i);
		}
		x.print();
		System.out.println(x.size(x.root));
		x.inOrder(x.root);
		x.preOrder(x.root);
		x.postOrder(x.root);
	}
}
