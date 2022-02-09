
public class QuickSortThreeWay implements SortingAlgorithm {

	public int[] partition(int[] A, int p, int r) {
		
		// We take the last element as the pivot
		int x = A[r];
		
		// Variable i - Last element in lesser than region
		// Variable j - Last element in equal region
		int i = p-1;
		int j = p-1;
		
		// Loop through k - the elements less than k are dealt with
		for (int k = p; k < r; k++) {
			
			
			// Now compare the element at k with the pivot
			if (A[k] < x) {
				
				// Change the region boundaries
				// Increment both the i & j counter
				// This means the size of the equal region isnt changed
				i = i + 1;
				j = j + 1;
				
				if (k == j) {
					SortingTools.swap(A, i, k);
				}else {
					// Make room at the start of the equals region
					// by swapping an element to the end
					SortingTools.swap(A, i, j);
					
					// Swap the element at the current position to the
					// space at the end of the lesser region				
					SortingTools.swap(A, i, k);
				}
				
			}else if( A[k] == x) {
				// Increment solely the j counter 
				// This will increase the size of the equal region
				j = j + 1;
				
				// Swap the element into the equal region
				SortingTools.swap(A, j, k);
			}
			
		}
		// Finally swap the pivot into the equal region
		j = j + 1;
		SortingTools.swap(A, j, r);
		
		
		// We need to return both indexes
		int[] indexes = {i, j};
		return indexes;
	}
	
	
	
	@Override
	public void sort(int[] A, int p, int r) {
		if (p<r) {
			int[] indexes = partition(A,p,r);
			// Sort the lesser partition
			sort(A,p,indexes[0]);
			
			// No need to sort the equal partition
			// The elements are all equal! :)
			
			// Sort the greater partition
			sort(A,indexes[1]+1,r);
		}
	}

}
