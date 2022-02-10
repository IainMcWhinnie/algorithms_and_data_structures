
public class TimeSortingAlgorithms {

	public static long timeSortingAlgorithmNano(int[] testArray, SortingAlgorithm sortAlg) {
		int arrayLastIndex = testArray.length-1;
		long startTime = System.nanoTime();
		sortAlg.sort(testArray, 0, arrayLastIndex);
		long stopTime = System.nanoTime();
		return stopTime-startTime;
	}
	
	public static long timeSortingAlgorithmNano(int[] testArray, QuickSortWithInsertionSortCutoff sortAlg, int intParam) {
		int arrayLastIndex = testArray.length-1;
		long startTime = System.nanoTime();
		sortAlg.sort(testArray, 0, arrayLastIndex, intParam);
		long stopTime = System.nanoTime();
		return stopTime-startTime;
	}
}
