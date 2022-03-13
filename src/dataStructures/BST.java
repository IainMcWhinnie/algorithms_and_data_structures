package dataStructures;

public class BST {
	private Node root;
	
	private class Node{
		private int key;
		private Node left, right, p;
		
		public Node(int key) {
			this.key = key;
			
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
		Node z = new Node(zKey);
		
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
	

	public Node extractMin() {
		Node minNode = min(root);
		delete(minNode);
		return minNode;
	}
	
	public static void main(String args[]) {
		BST x = new BST();
		int[] test = {5,4,6,7,1,2,3,8};
		for (int i: test) {
			x.insert(i);
		}
		System.out.println(x.size(x.root));
		x.inOrder(x.root);
		x.preOrder(x.root);
		x.postOrder(x.root);
		
	}
}
