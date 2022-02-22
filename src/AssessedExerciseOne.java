import java.nio.file.Paths;

public class AssessedExerciseOne {
	
	public static int[][] getTestArrays(){
		int[] arrayTest = {6, 5, 0, 4, 1, 8, 3, 4, 4, 2, 5, 6, 4, 6, 5};
		int[] array1000 = ArrayFromFile.getFromPath(Paths.get(".\\int1000.txt"));
		int[] array20k = ArrayFromFile.getFromPath(Paths.get(".\\int20k.txt"));
		int[] array500k = ArrayFromFile.getFromPath(Paths.get(".\\int500k.txt"));
		int[] arrayDutch = ArrayFromFile.getFromPath(Paths.get(".\\dutch.txt"));
		int[] arrayBig = ArrayFromFile.getFromPath(Paths.get(".\\intBig.txt"));
		int[][] testArrays = {arrayTest, array1000, array20k, array500k, arrayDutch, arrayBig};
		return testArrays;
	}
	
	public static void testAlgorithm(SortingAlgorithm sortAlg) {
		
		int[][] testArrays = getTestArrays();
		
		for (int[] testArray: testArrays) {
			long timeTaken = TimeSortingAlgorithms.timeSortingAlgorithmNano(testArray, sortAlg);
			boolean correctOutput = TestSortingAlgorithms.assertSortedAsc(testArray);
			System.out.println(String.format("%20s", "Size("+testArray.length+") : ")+correctOutput+", "+timeTaken+" ns");
		}
		
	}
	
	public static void testCutoffAlgorithm(QuickSortWithInsertionSortCutoff sortAlg, int cutoff) {
		int[][] testArrays = getTestArrays();
		
		for (int[] testArray: testArrays) {
			long timeTaken = TimeSortingAlgorithms.timeSortingAlgorithmNano(testArray, sortAlg, cutoff);
			boolean correctOutput = TestSortingAlgorithms.assertSortedAsc(testArray);
			System.out.println(String.format("%20s", "Size("+testArray.length+") : ")+correctOutput+", "+timeTaken+" ns");
		}
	}
	
	public static void runBroadTest() {
		System.out.println("Testing sorting algorithms\n");
		System.out.println("For each algorithm test for correctness and time how long it takes to execute.");
		
		SortingAlgorithm quickSort = new QuickSort();
		System.out.println("\nQuick Sort Test");
		testAlgorithm(quickSort);
		
		SortingAlgorithm quickSortMedianOfThree = new QuickSortMedianOfThreeMethod();
		System.out.println("\nQuick Sort with Median of Three pivot Test");
		testAlgorithm(quickSortMedianOfThree);
		
		SortingAlgorithm quickSortWithInsertionCutoff = new QuickSortWithInsertionSortCutoff();
		System.out.println("\nQuick Sort with a cutoff to Insertion sort Test Default Cutoff: 15");
		testAlgorithm(quickSortWithInsertionCutoff);
		
		SortingAlgorithm quickSortThreeWay = new QuickSortThreeWay();
		System.out.println("\nThree-way Quick Sort Test");
		testAlgorithm(quickSortThreeWay);
		
		SortingAlgorithm mergeSort = new MergeSort();
		System.out.println("\nMerge Sort Test");
		testAlgorithm(mergeSort);
		
		SortingAlgorithm insertionSort = new InsertionSort();
		System.out.println("\nInsertion Sort Test");
		testAlgorithm(insertionSort); // WARNING: THIS CAN TAKE SOME TIME!!
		
		System.out.println();
	}
	
	public static void runCutoffTest() {
		
		System.out.print("Testing different cutoffs to insertion sort in the quick/insertion sort algorithm.\n");
		
		System.out.println("\nTesting with cutoff of 5");
		QuickSortWithInsertionSortCutoff sortAlg = new QuickSortWithInsertionSortCutoff();
		testCutoffAlgorithm(sortAlg, 5);
		
		System.out.println("\nTesting with cutoff of 10");
		testCutoffAlgorithm(sortAlg, 10);
		
		System.out.println("\nTesting with cutoff of 30");
		testCutoffAlgorithm(sortAlg, 30);
		
		System.out.println("\nTesting with cutoff of 50");
		testCutoffAlgorithm(sortAlg, 50);
		
		System.out.println("\nTesting with cutoff of 60");
		testCutoffAlgorithm(sortAlg, 60);
		
		System.out.println("\nTesting with cutoff of 80");
		testCutoffAlgorithm(sortAlg, 80);
		
		System.out.println("\nTesting with cutoff of 100");
		testCutoffAlgorithm(sortAlg, 100);
		
		System.out.println("\nTesting with cutoff of 1000");
		testCutoffAlgorithm(sortAlg, 1000);
	}
	
	public static void main(String[] args) {
		System.out.println("RUNNING ALL TESTS");
		System.out.println("--".repeat(50));
		
		runBroadTest();
		
		System.out.println("--".repeat(50));
		
		runCutoffTest();
	}
}
