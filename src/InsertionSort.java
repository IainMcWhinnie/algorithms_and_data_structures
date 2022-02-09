
public class InsertionSort {
	public static void sort(int[] A, int p, int r) {
		java.util.Arrays.parallelSort(A, p, r+1);
	}
}
