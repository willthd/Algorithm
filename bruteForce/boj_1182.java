package practice;

import java.util.*;

public class Main7 {
	static int n, sum, r, a[], num[], result;
	
	public static void f(int dep, int st, int r) {
		if (dep == r) {
			int v = 0;
			for (int i = 0; i < r; i++) {
				v += a[i];
			}
			if (v == sum) {
				result++;
			}
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = num[i];
			f(dep + 1, i + 1, r);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sum = sc.nextInt();
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a = new int[i + 1];
			f(0, 0, i + 1);
		}
		System.out.println(result);
	}
}