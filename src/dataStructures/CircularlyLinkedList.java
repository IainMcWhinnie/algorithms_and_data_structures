package dataStructures;

public class CircularlyLinkedList<Item extends Comparable> {
	private Node<Item> sentinel;
	
	private static class Node<Item>{
		private Item key;
		private Node<Item> next;
		private Node<Item> prev;
	}
	
	public CircularlyLinkedList() {
		sentinel = new Node<Item>();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	
	public void pushFront(Item y) {
		Node<Item> x = new Node<>();
		x.key = y;
		x.next = sentinel.next;
		sentinel.next.prev = x;
		sentinel.next = x;
		x.prev = sentinel;
	}
	
	public void pushBack(Item y) {
		Node<Item> x = new Node<>();
		x.key = y;
		x.next = sentinel;
		sentinel.prev.next = x;
		sentinel.prev = x;
		x.next = sentinel;
	}
	
	public Item popFront() {
		Node<Item> x = sentinel.next;
		x.prev.next = x.next;
		x.next.prev = x.prev;
		return x.key;
	}
	
	public Item popBack() {
		Node<Item> x = sentinel.prev;
		x.prev.next = x.next;
		x.next.prev = x.prev;
		return x.key;
	}
	
	public void printme() {
		Node<Item> cur = sentinel.next;
		while (cur.key != null) {
			System.out.print(cur.key+ ", ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static CircularlyLinkedList<Integer> init(int[] array){
		CircularlyLinkedList<Integer> newList = new CircularlyLinkedList<Integer>();
		for (int el: array) {
			newList.pushBack(el);
		}
		return newList;
	}
	
	public static void main(String args[]) {
		int[] sortme = {4,2,65,2,4,7,2,7,3,576,472,3,3567,2,47,4336543,353,45,2,2};
		CircularlyLinkedList<Integer> test = init(sortme);
		test.printme();
		System.out.println("Popped from front: "+test.popFront());
		test.printme();
	}
	
}
