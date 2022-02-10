
public class QuickSortWithInsertionSortCutoff extends QuickSort{
	
	@Override
	public void sort(int[] A, int p, int r) {
		sort(A,p,r,15);
	}
	
	public void sort(int[] A, int p, int r, int k) {
		partialSort(A,p,r,k);
		SortingAlgorithm finalSort = new InsertionSort();
		finalSort.sort(A,p,r);
	}
	
	public void partialSort(int[] A, int p, int r, int k) {
		if ( (r-p) >= k ) {
			if (p < r) {
				int q = partition(A,p,r);
				partialSort(A,p,q-1,k);
				partialSort(A,q+1,r,k);
			}
		}
	}


}
