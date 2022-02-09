
public class QuickSort implements SortingAlgorithm{
	
	public int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j<r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				SortingTools.swap(A,i,j);
			}
		}
		SortingTools.swap(A,i+1,r);
		return i + 1;
	}
	
	
	@Override
	public void sort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A,p,r);
			sort(A,p,q-1);
			sort(A,q+1,r);
		}
	}
}
