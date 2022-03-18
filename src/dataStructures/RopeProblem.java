package dataStructures;
import dataStructures.ArrayMinHeap;
import dataStructures.minPriorityQueue;


public class RopeProblem {
	
	public static void solve(int[] ropeSections) {
		
		// Set up the Min-priority ADT
		// and populate it
		minPriorityQueue ropeLengths = ArrayMinHeap.buildMinHeap(ropeSections);
		
		
		// Declare the variables and fetch the starting two lengths of rope
		int newSection;
		int totalCost = 0;
		int firstSection =  ropeLengths.extractMin();
		int secondSection = ropeLengths.extractMin();
		
		// Iterate through each join until there is no rope sections left
		while(firstSection != -1 && secondSection != -1) {
			System.out.println("Join on the section of length "+firstSection+" with the section of length "+secondSection);
			newSection = firstSection + secondSection;
			totalCost += newSection;
			
			// Add the new section back into the minQueue
			ropeLengths.insert(newSection);
			
			// Compute the next two sections using the minQueue
			firstSection =  ropeLengths.extractMin();
			secondSection = ropeLengths.extractMin();
		}
		
		// Report the total cost
		System.out.println("The total cost was "+totalCost);
	}
	
	public static void main(String args[]) {
		int[] testProblem = {4,8,3,1,6,9,12,7,2};
		
		solve(testProblem);
	}
}
