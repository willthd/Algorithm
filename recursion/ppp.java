import java.util.*;

public class ppp {
	
	static long gcd(long a, long b) {
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		if (max % min == 0) {
			return min;
		} else {
			return gcd(min, max % min);
		}
	}
	
	static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(lcm(n, m));
	}
}