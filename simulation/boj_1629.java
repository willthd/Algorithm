package practice;

import java.util.*;

public class Main5 {
	static int a, b, c;
	
	static long f(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long temp = f(a, b/2);
	    long result = (long) (1 * temp * temp) % c;
	    if(b % 2 == 1) {
	    		result = (1 * result * a) % c;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		System.out.println(f(a, b));
	}
}