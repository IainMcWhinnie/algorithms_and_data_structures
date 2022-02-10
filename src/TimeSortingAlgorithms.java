import java.nio.file.Paths;

public class TimeSortingAlgorithms {
	public static void main(String[] args) {
		System.out.println("Timing Sorting Algorithms");
		
		int[] testArray = ArrayFromFile.getFromPath(Paths.get(".\\int20k.txt"));
		//int[] testArray = {6, 5, 0, 4, 1, 8, 3, 4, 4, 2, 5, 6, 4, 6, 5};
		
		System.out.println("Testing array of size "+testArray.length);
		
		SortingAlgorithm sortAlg = new QuickSortThreeWay();
		
		long[] timesTaken = timeSortingAlgorithmIterated(testArray, sortAlg, 10);
		java.util.Arrays.sort(timesTaken);
		long median = timesTaken[(timesTaken.length)/2];
		
		System.out.println("Is sorted: "+TestSortingAlgorithms.assertSortedAsc(testArray));
		
		System.out.println("Took a median time of "+median+" ns");
		
	}
	
	
	public static long timeSortingAlgorithmNano(int[] testArray, SortingAlgorithm sortAlg) {
		int arrayLastIndex = testArray.length-1;
		long startTime = System.nanoTime();
		sortAlg.sort(testArray, 0, arrayLastIndex);
		long stopTime = System.nanoTime();
		return stopTime-startTime;
	}
	
	public static long[] timeSortingAlgorithmIterated(int[] testArray, SortingAlgorithm sortAlg, int n) {
		long[] results = new long[n];
		for (int i = 0; i<n; i++) {
			results[i] = timeSortingAlgorithmNano(testArray, sortAlg);
		}
		return results;
	}
}
