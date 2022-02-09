
public class InsertionSort implements SortingAlgorithm{
	
	public void sort(int[] A, int p, int r) {
		
		for (int j = p+1; j <= r; j++) {
			int key = A[j];
			int i = j-1;
			while (i >= 0 && A[i] > key) {
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
		
	}
}
