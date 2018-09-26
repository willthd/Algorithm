package practice;

import java.util.*;

public class Main7 {
	static int r, zero, one, a[], count[];
	
	public static void f(int dep) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i]);
			}
			System.out.print(" ");
			return;
		}
		for (int i = 0; i < 2; i++) {
			if (count[i] == 0) {
				continue;
			}
			count[i]--;
			a[dep] = i;
			f(dep + 1);
			count[i]++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		a = new int[r];
		count = new int[2];
		one = sc.nextInt();
		zero = r - one;
		count[0] = zero;
		count[1] = one;
		f(0);
	}
}