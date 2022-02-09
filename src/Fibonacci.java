
public class Fibonacci {
	public static int fib(int n) {
		if (n <= 2) {
			return 1;
		}else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	// 1:1, 2:1, 3:2, 4:3, 5: 5
	
	public static int fibTail(int n, int i, int prev, int prev2) {
		if (i==n) {
			return prev;
			
		}else if(i <= 1) {
			// When i = 0 then prev = 0 & prev2 = 1
			// When i = 1 then prev = 1 & prev2 = 0
			// Either way the answer is 1
			return fibTail(n, i+1, 1, 1);
			
		}else {
			int past = prev;
			prev = prev + prev2;
			return fibTail(n, i+1, prev, past);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Testing fibonacci");
		
		System.out.println("Fib(4) = "+fib(4));
		System.out.println("Fib(16) = "+fib(16));
		
		System.out.println("Fib(4) = "+fibTail(4, 0, 0, 0));
		System.out.println("Fib(100) = "+fibTail(100, 0, 0, 0));
	}
}
