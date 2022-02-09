
public final class SortingTools {
	
	public static void swap(int[] A, int firstIndex, int secondIndex) {
		int tmp = A[firstIndex];
		A[firstIndex] = A[secondIndex];
		A[secondIndex] = tmp;
	}
	
}
