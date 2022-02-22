package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<Item extends Comparable> {
	private Node<Item> head;
	
	private static class Node<Item>{
		private Item key;
		private Node<Item> next;
	}
	
	public LinkedList() {
		this.head = null;
	}
	
	
	public Node<Item> mergeSort(Node<Item> a) {
		if (a == null || a.next == null) {
			return a;
		}
		List<Node<Item>> partition = split(a);
		Node<Item> x = mergeSort(partition.get(0));
		Node<Item> y = mergeSort(partition.get(1));
		return merge(x,y);
	}
	
	public List<Node<Item>> split(Node<Item> a){
		List<Node<Item>> splitIndexes = new ArrayList<>();
		if (a == null || a.next == null) {
			splitIndexes.add(a);
			splitIndexes.add(null);
			return splitIndexes;
		}
		Node<Item> slow = a;
		Node<Item> fast = a.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node<Item> mid = slow.next;
		slow.next = null;
		splitIndexes.add(a);
		splitIndexes.add(mid);
		return splitIndexes;
	}
	
	public Node<Item> merge(Node<Item> a, Node<Item> b){
		if (a == null) {
			return b;
		}else if (b == null) {
			return a;
		}
		Node<Item> x = null;
		if (a.key.compareTo(b.key) < 0) {
			x = a;
			x.next = merge(a.next,b);
		}else {
			x = b;
			x.next = merge(a,b.next);
		}
		return x;
	}
	
	public void insert(Node<Item> x) {
		x.next = head;
		head = x;
	}
	
	public void printme() {
		Node<Item> cur = head;
		while (cur != null) {
			System.out.print(cur.key+ ", ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static LinkedList<Integer> init(int[] array){
		LinkedList<Integer> newList = new LinkedList<Integer>();
		for (int el: array) {
			Node<Integer> x = new Node<Integer>();
			x.key = el;
			newList.insert(x);
		}
		return newList;
	}
	
	public static void main(String args[]) {
		int[] sortme = {4,2,65,2,4,7,2,7,3,576,472,3,3567,2,47,4336543,353,45,2,2};
		LinkedList<Integer> test = init(sortme);
		test.mergeSort(test.head);
		test.printme();
	}
	
}
