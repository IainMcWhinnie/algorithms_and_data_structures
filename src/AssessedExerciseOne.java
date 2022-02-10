import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AssessedExerciseOne {
	
	public static void main(String[] args) {
		System.out.println("Testing sorting algorithms");
		
		int[] arrayTest = {6, 5, 0, 4, 1, 8, 3, 4, 4, 2, 5, 6, 4, 6, 5};
		int[] array1000 = ArrayFromFile.getFromPath(Paths.get(".\\int1000.txt"));
		int[] array20k = ArrayFromFile.getFromPath(Paths.get(".\\int20k.txt"));
		int[] array500k = ArrayFromFile.getFromPath(Paths.get(".\\int500k.txt"));
		int[] arrayDutch = ArrayFromFile.getFromPath(Paths.get(".\\dutch.txt"));
		int[] arrayBig = ArrayFromFile.getFromPath(Paths.get(".\\intBig.txt"));
		
		int[][] testArrays = {arrayTest, array1000, array20k, array500k, arrayDutch, arrayBig};
		
		Map<String, SortingAlgorithm> algorithms = new HashMap<>();
		
		//algorithms.put("Quick Sort", new QuickSort());
		//algorithms.put("Quick Sort with an Insertion Sort Cutoff", new QuickSortWithInsertionSortCutoff());
		//algorithms.put("Quick Sort with Median of Three Pivot", new QuickSortMedianOfThreeMethod());
		//algorithms.put("3-Way Quick Sort", new QuickSortThreeWay());
		algorithms.put("Insertion Sort", new InsertionSort());
		algorithms.put("Merge Sort", new MergeSort());
		
		
		for (int[] testArray: testArrays) {
			System.out.println();
			System.out.println("--".repeat(20));
			System.out.println("Testing on array of size "+testArray.length);
			
			for (String algName: algorithms.keySet()) {
				System.out.print(algName+": ");
				boolean correctOutput = TestSortingAlgorithms.testSortingAlgorithm(testArray, algorithms.get(algName));
				long timeTaken = TimeSortingAlgorithms.timeSortingAlgorithmNano(testArray, algorithms.get(algName));
				System.out.println(correctOutput+" "+timeTaken+" ns");
			}
			
			System.out.println();
		}
		
		
	}
}
