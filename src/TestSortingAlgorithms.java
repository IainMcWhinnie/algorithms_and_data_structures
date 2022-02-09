import java.nio.file.Paths;

public class TestSortingAlgorithms {
	public static void main(String[] args) {
		System.out.println("Testing sorting algorithms");
		
		int[] testArray = ArrayFromFile.getFromPath(Paths.get(".\\int1000.txt"));
		//int[] testArray = {6, 5, 0, 4, 1, 8, 3, 4, 4, 2, 5, 6, 4, 6, 5};
		
		System.out.println("Testing array of size "+testArray.length);
		
		SortingAlgorithm sortAlg = new QuickSortThreeWay();
		
		sortAlg.sort(testArray,0,testArray.length-1);
		
		int sizeToShow = testArray.length;
		if (sizeToShow > 150) {
			sizeToShow = 150;
		}
		
		System.out.println("Is sorted: "+assertSortedAsc(testArray));
		
		for (int i = 0; i < sizeToShow; i++) {
			System.out.print(testArray[i]+", ");
		}
		
		
	}
	
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
}
