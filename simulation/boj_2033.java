package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= 7; i++) {
			int a = (int) Math.pow(10, i);
			if (n > a) {
				int mok = n / a;
				int na = n % a;
				if (na >= 5 * (a / 10)) {
					mok++;
				}
				n = mok * a;
			}
		}
		System.out.println(n);
	}
}