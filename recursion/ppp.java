package practice;

import java.util.*;

public class ppp {
	
	static int lcm(int a, int b) {
		if (a % b == 0) {
			return a;
		} else {
			return a * b / gcd(a, b);
		}
	}
	
	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}
}
