package practice;

import java.util.*;

// SWEA, 2115, 벌꿀채취
public class pp {
	static int n, m, c, g[][], p[][];

	static int getPSum(int mm, int y, int x, int sum, int powSum) {
		if (mm == m) {
			return powSum;
		}
		int max = 0;
		int next;
		if (sum + g[y][x + mm] <= c) {
			next = getPSum(mm + 1, y, x, sum + g[y][x + mm], powSum + g[y][x + mm] * g[y][x + mm]);
			max = Math.max(next, max);
		}
		next = getPSum(mm + 1, y, x, sum, powSum);
		max = Math.max(next, max);
		return max;
	}
	
	static int getPairSum(int y, int x) {
		int max = 0;
		for (int i = x + m; i <= n - m; i++) {
			max = Math.max(max, p[y][i]);
		}
		for (int i = y + 1; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				max = Math.max(max, p[i][j]);
			}
		}
		return max;
	}

	static int solve() {
		int max = 0;
		// 요게 관건이네
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				p[i][j] = getPSum(0, i, j, 0, 0);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				int sum = p[i][j] + getPairSum(i, j);
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			g = new int[n][n];
			m = sc.nextInt();
			p = new int[n][n - m + 1];
			c = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + solve());
		}
	}
}
