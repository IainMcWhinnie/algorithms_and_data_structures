package dataStructures;

public class ArrayMinHeap<Item extends Comparable> {
	private Item[] h;
	private int head;
	private int tail;
	private int n;
	
	public ArrayMinHeap() {
		h = (Item[]) new Object[2];
		head = 0;
		tail = 0;
	}
	
	public void insert(Item x) {
		if (n == h.length) {
			resize(2*h.length);
		}
		tail = (tail+1)%h.length;
		h[tail] = x;
		n++;
		minHeapify(tail);
	}
	
	public int left(int i) {
		return (2*i)+1;
	}
	
	public int right(int i) {
		return (2*i)+2;
	}
	
	public void minHeapify(int i) {
		int smallest;
		int l = left(i);
		int r = right(i);
		if (l < n && h[l].compareTo(h[i])<0 ) {
			smallest = l;
		}else {
			smallest = i;
		}
		if (r < n && h[r].compareTo(h[largest]) < 0) {
			smallest = r;
		}
		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
	
	public void swap(int index1, int index2) {
		Item tmp = h[index2];
		h[index2] = h[index1];
		h[index1] = tmp;
	}
	
	public Item min() {
		return null;
	}
	
	public Item extractMin() {
		return null;
	}
	
	public void resize(int newSize) {
		Item[] newH = (Item[]) new Object[newSize];
		for (int i=0; i<n; i++) {
			newH[i] = h[(head+i)%newSize];
		}
		h = newH;
		head = 0;
		tail = n-1;
	}
	
	public static void main(String[] args) {
		int[] test = {1,4,2,65,3,6,3,6,3,56,8,2,8,9};
		ArrayMinHeap<Integer> heap = new ArrayMinHeap<>();
		
		
		for (int el: test) {
			heap.insert(el);
		}
		System.out.print(heap.h);
	}
}
