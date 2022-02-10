public class TestSortingAlgorithms {
	
	
	public static boolean assertSortedAsc(int A[]) {
		if (A.length > 0) {
			int prevElement = A[0];
			for (int i = 1; i < A.length; i++) {
				if ( A[i] < prevElement) {
					return false;
				}
				prevElement = A[i];
			}
		}
		return true;
	}
	
	public static boolean testSortingAlgorithm(int[] testArray, SortingAlgorithm sortAlg) {
		int[] cloneArray = testArray.clone();
		sortAlg.sort(cloneArray, 0, cloneArray.length-1);
		return assertSortedAsc(cloneArray);
	}
}
