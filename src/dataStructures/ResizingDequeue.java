package dataStructures;

public class ResizingDequeue<Item> {
	private Item[] q;
	private int n; // number of elements in the dequeue
	private int tail;
	private int head;
	
	public ResizingDequeue() {
		q = (Item[]) new Object[2];
		n = 0;
		head = 0;
		tail = 0;
	}
	
	public void pushBack(Item x) {
		if (n == q.length) {
			resize(2*q.length);
		}
		q[tail] = x;
		tail = (tail+1)%q.length;
		n++;
	}
	
	public void pushFront(Item x) {
		if (n == q.length) {
			resize(2*q.length);
		}
		head = (head + q.length-1)%q.length;
		q[head] = x;
		n++;
	}
	
	public Item popBack() {
		if (isEmpty()) {
			System.out.println("Error Underflow");
			return null;
		}
		tail = (tail + q.length-1)%q.length;
		Item x = q[tail];
		n--;
		if (n == q.length/4) {
			resize(q.length/2);
		}
		return x;
	}
	
	public Item popFront() {
		if (isEmpty()) {
			System.out.println("Error Underflow");
			return null;
		}
		Item x = q[head];
		head = (head + 1)%q.length;
		n--;
		if (n == q.length/4) {
			resize(q.length/2);
		}
		return x;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public void resize(int newN) {
		Item[] newQ = (Item[]) new Object[newN];
		for (int i = 0; i <= n-1; i++) {
			newQ[i] = q[(head + i)%q.length];
		}
		q = newQ;
		head = 0;
		tail = n;
	}
	
	public static void main(String args[]) {
		ResizingDequeue<Integer> test = new ResizingDequeue<>();
		test.pushBack(1);
		System.out.println(java.util.Arrays.toString(test.q));
		test.pushBack(3);
		System.out.println(java.util.Arrays.toString(test.q));
		test.pushBack(2);
		System.out.println(java.util.Arrays.toString(test.q));
		test.popFront();
		System.out.println(java.util.Arrays.toString(test.q));
		test.pushFront(99);
		System.out.println(java.util.Arrays.toString(test.q));
		test.pushFront(88);
		System.out.println(java.util.Arrays.toString(test.q));
		test.pushBack(101);
		System.out.println(java.util.Arrays.toString(test.q));
	}
}
