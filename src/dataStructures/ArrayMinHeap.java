package dataStructures;

public class ArrayMinHeap {
	private int[] h;
	private int tail;
	
	public ArrayMinHeap() {
		h = new int[2];
		tail = 0;
	}
	
	public void insert(int x) {
		if (tail >= h.length) {
			resize(2*h.length);
		}
		
		h[tail] = x;
		
		int nodeToFix = tail;
		int parentOfFix = parent(nodeToFix);
		
		while (h[parentOfFix] > h[nodeToFix]) {
			swap(parentOfFix, nodeToFix);
			nodeToFix = parent(nodeToFix);
			parentOfFix = parent(nodeToFix);
		}
		
		tail++;
	}
	
	public int left(int i) {
		return (2*i)+1;
	}
	
	public int right(int i) {
		return (2*i)+2;
	}
	
	public int parent(int i) {
		return i/2;
	}
	
	public void minHeapify(int i) {
		int smallest;
		int l = left(i);
		int r = right(i);
		if (l < tail && h[l]<h[i]) {
			smallest = l;
		}else {
			smallest = i;
		}
		if (r < tail && h[r] < h[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
	
	public void print() {
		System.out.print("Heap: ");
		for (int i=0; i<tail; i++) {
			System.out.print(h[i]+",");
		}
		System.out.print(" (arraysize: "+h.length+" )");
		System.out.println();
	}
	
	public void swap(int index1, int index2) {
		int tmp = h[index2];
		h[index2] = h[index1];
		h[index1] = tmp;
	}
	
	public int min() {
		return h[0];
	}
	
	public int extractMin() {
		int minEl = h[0];
		
		int lastEl = tail-1;
		h[0] = h[lastEl];
		tail--;
		minHeapify(0);
		
		if ((tail-1)*4 < h.length) {
			resize(h.length/2);
		}
	
		return minEl;
	}
	
	public void resize(int newSize) {
		int[] newH = new int[newSize];
		for (int i=0; i<tail; i++) {
			newH[i] = h[i];
		}
		h = newH;
	}
	
	public static ArrayMinHeap buildMinHeap(int[] input) {
		ArrayMinHeap newHeap = new ArrayMinHeap();
		for (int el: input) {
			newHeap.insert(el);
		}
		return newHeap;
	}
	
	public static void main(String[] args) {
		int[] test = {5, 3, 8, 234, 45, 7, 2345, 94, 23567};
		ArrayMinHeap heap = buildMinHeap(test);
		
		for (int i=0; i<test.length; i++) {
			heap.print();
			System.out.println(heap.min());
			System.out.println(heap.extractMin());
		}
		
		heap.print();
		
	}
}
