
public class QuickSortAdversary {
	
	public static int[] generateAdversary(int n) {
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

}
