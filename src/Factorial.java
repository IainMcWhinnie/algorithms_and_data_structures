
public class Factorial {

	public static int fact(int n) {
		if(n==1) {
			return 1;
		}else {
			return n*fact(n-1);
		}
	}
	
	public static int factTail(int n, int total) {
		if (n==1) {
			return total;
		}else {
			total = total * n;
			return factTail(n-1, total);
		}
	}
	
	public static int factIter(int n) {
		int total = 1;
		while (n >1) {
			total = total*n;
			n--;
		}
		return total;
	}
	
	public static void main(String args[]) {
		System.out.println("Testing Factorial Functions...");
		
		System.out.println("4! = "+fact(4));
		System.out.println("16! = "+fact(16));
		
		System.out.println("4! = "+factTail(4, 1));
		System.out.println("16! = "+factTail(16, 1));
		
		System.out.println("4! = "+factIter(4));
		System.out.println("16! = "+factIter(16));
		
	}
}
