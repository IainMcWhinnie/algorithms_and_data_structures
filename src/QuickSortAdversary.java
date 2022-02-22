
public class QuickSortAdversary {
	
	public static int[] generateAdversary(int n) {
<<<<<<< HEAD
		int[] A = new int[n];
		int cur = n-1;
		int i = 0;
		while (cur >= 0) {
			A[i] = cur;
			cur = cur - 2;
			i++;
		}
		cur = 1 - (cur+2);
		while (cur < n) {
			A[i] = cur;
			cur = cur + 2;
			i++;
		}
		return A;
	}
	
	
	public static void main(String[] args) {
		int[] a = generateAdversary(10);
		
		QuickSortMedianOfThreeMethod quickSort = new QuickSortMedianOfThreeMethod();
		
		System.out.println("Let see how long this takes");
		quickSort.sort(a, 0, a.length-1);
		System.out.println("DOnE");
	}
=======
		int[] a = new int[n];
		int middle = (n+1)/2;
		for(int i=0; i<middle; i++) {
			a[i] = 2*i;
		}
		for(int j=0; j<n-middle; j++) {
			a[middle+j] = (2*j)+1;
		}
		return a;
	}
	
>>>>>>> 554ffa3c10eb45b1c986104a79516536a1428140
}
