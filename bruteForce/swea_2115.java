package practice;

import java.util.*;

public class Main4 {
	static int n, m, c, g[][], a[], max = Integer.MIN_VALUE, result, result_max;
	static boolean v[][], vv[];
	
	public static void f2(int dep, int x, int y) {
		if (dep == m) {
			int total = 0;
			int val = 0;
			for (int i = 0; i < m; i++) {
				total += a[i];
				val += Math.pow(a[i], 2);
				if (total > c) {
					total -= a[i];
					val -= Math.pow(a[i], 2);
					break;
				}
			}
			max = Math.max(max, val);
			return;
		}
		for (int i = 0; i < m; i++) {
			if (vv[i]) {
				continue;
			}
			vv[i] = true;
			a[dep] = g[x][y + i];
			f2(dep + 1, x, y);
			vv[i] = false;
		}
	}
	
	public static void f1(int dep, int st) {
		if (dep == 2) {
			result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (v[i][j]) {
						max = 0;
						a = new int[m];
						vv = new boolean[m];
						f2(0, i, j);
						j += m - 1;
						result += max;
					}
				}
			}
//			System.out.println("hap : " + result);
			result_max= Math.max(result_max, result);
//			System.out.println("----");
			return;
		}
		for (int i = st; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				if (check1(i, j)) {
					continue;
				}
				for (int k = 0; k < m; k++) {
					v[i][j + k] = true;
				}
				f1(dep + 1, i);
				for (int k = 0; k < m; k++) {
					v[i][j + k] = false;
				}
			}
		}
	}
	
	public static boolean check1(int x, int y) {
		for (int k = 0; k < m; k++) {
			if (v[x][y + k]) {
				return true;
			}
		}
		return false;
	}
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int t = sc.nextInt();
		 for (int tc = 0; tc < t; tc++) {
			 result_max = Integer.MIN_VALUE;
			 n = sc.nextInt();
			 m = sc.nextInt();
			 c = sc.nextInt();
			 g = new int[n][n];
			 v = new boolean[n][n];
			 for (int i = 0; i < n; i++) {
				 for (int j = 0; j < n; j++) {
					 g[i][j] = sc.nextInt();
				 }
			 }
			 f1(0, 0);
			 System.out.println("#" + (tc + 1) + " " + result_max);
		 }
	 }
}