import java.nio.file.Paths;

public class QuickSort {
	
	public static void swap(int[] A, int firstIndex, int secondIndex) {
		int tmp = A[firstIndex];
		A[firstIndex] = A[secondIndex];
		A[secondIndex] = tmp;
	}
	
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j<r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				swap(A,i,j);
			}
		}
		swap(A,i+1,r);
		return i + 1;
	}
	
	public static int partitionOnMedianOfThree(int[] A, int p, int r) {
		int tmp;
		int hi = 0, lo = 0;
		int mid = (p + r)/2;
		if (A[mid] < A[lo]) { swap(A, mid,lo); }
		if (A[hi] < A[lo]) { swap(A, hi,lo); }
		if (A[mid] < A[hi]) { swap(A, mid,hi); }
			
		
		
		
		int x = A[r];
		int i = p - 1;
		for (int j = p; j<r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		return i + 1;
	}
	
	public static void sort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A,p,r);
			sort(A,p,q-1);
			sort(A,q+1,r);
		}
	}
	
	public static void sortWithSizeCutoff(int[] A, int p, int r, int k) {
		if ( (r-p) >= k ) {
			if (p < r) {
				int q = partition(A,p,r);
				sortWithSizeCutoff(A,p,q-1,k);
				sortWithSizeCutoff(A,q+1,r,k);
			}
		}
	}
	
	public static void sortWithCutoffAndInsertion(int[] A, int p, int r, int k) {
		sortWithSizeCutoff(A,p,r,k);
		InsertionSort.sort(A, p, r);
	}
	
	public static void main(String args[]) {
		int[] A = ArrayFromFile.getFromPath(Paths.get("C:\\Users\\2566283M\\eclipse-workspace\\ADS_AE1\\int1000.txt"));
		int[] test = {2,4,5,2,5,1,6,3,8,5,8,2,4,545,45,25,235,2,65,3,345,45,2,0};
		sortWithCutoffAndInsertion(test,0,test.length-1,5);
		
		for (int x: test) {
			System.out.print(x+", ");
		}
	}
	
}
