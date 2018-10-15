package practice;

import java.util.*;

public class Main5 {
	static int a, b, c;

	static long f(long a, long b) {
		if (b == 0) {
			return 1;
		} else if (b % 2 == 0) {
			return (long) ((long)Math.pow((long)f(a, b / 2), 2) % c);
		} else {
			return (long) ((long)Math.pow((long)f(a, b / 2), 2) * (a % c)) % c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		System.out.println(f(a, b));
	}
}