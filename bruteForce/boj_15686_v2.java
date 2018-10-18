package practice;

import java.util.*;

public class Main4 {
	static int n, g[][], m, result = Integer.MAX_VALUE;
	static boolean v[][];
	
	public static void f(int dep, int st) {
		if (dep == m) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (g[i][j] == 1) {
						int min_len = Integer.MAX_VALUE;
						for (int p = 0; p < n; p++) {
							for (int q = 0; q < n; q++) {
								if (v[p][q]) {
									int len = (int)Math.abs(i - p) + (int)Math.abs(j - q);
									min_len = Math.min(min_len, len);
								}
							}
						}
						sum += min_len;
					}
				}
			}
			result = Math.min(sum, result);
			return;
		}
		for (int i = st; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] != 2) {
					continue;
				}
				if (v[i][j]) {
					continue;
				}
				v[i][j] = true;
				f(dep + 1, i);
				v[i][j] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][n];
		m = sc.nextInt();
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		f(0, 0);
		System.out.println(result);
	}
}