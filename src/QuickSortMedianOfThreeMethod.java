
public class QuickSortMedianOfThreeMethod extends QuickSort {
	
	@Override
	public int partition(int[] A, int p, int r) {

		
		int top = r, bottom = p;
		int mid = (top + bottom)/2;
		// Arrange the lowest value to be at the bottom place
		if (A[mid] < A[bottom]) { SortingTools.swap(A,mid,bottom); }
		if (A[top] < A[bottom]) { SortingTools.swap(A,top,bottom); }
		
		// Now take the lowest of the other two and put it
		// in the top place to be used as the key as it is the median values
		if (A[mid] < A[top]) { SortingTools.swap(A,mid,top); }
			
		
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
	
}
