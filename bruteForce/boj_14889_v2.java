package practice;

import java.util.*;

public class Main7 {
	static int n, a[], g[][], min = (int)1e9;
	
	public static void f(int dep, int st) {
		if (dep == n / 2) {
			boolean check[] = new boolean[n];
			for (int i = 0; i < n / 2; i++) {
				check[a[i]] = true;
			}
			int sum1 = 0;
			int sum2 = 0;
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i] && check[j]) {
						sum1 += g[i][j];						
					}
					if (!check[i] && !check[j]){
						sum2 += g[i][j];
					}
				}
			}
			result = Math.abs(sum1 - sum2);
			for (int i = 0; i < n / 2; i++) {
				System.out.print((a[i] + 1) + " ");
			}
			System.out.println();
			System.out.println("sum1 : " + sum1 + ", sum2 : " + sum2 + ", result : " + result);
			if (min > result) {
				min = result;
			}
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = i;
			f(dep + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n / 2];
		g = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		f(0, 0);
		System.out.println("min : " + min);
	}
}