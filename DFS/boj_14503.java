package practice;

import java.util.*;

public class Main4 {
	static int n, m, g[][];
	
	public static void dfs(int r, int c, int d, int dep) {
		g[r][c] = 2;
		int new_d = d - 1;
		if (new_d < 0) {
			new_d += 4;
		}
		int new_r = -1;
		int new_c = -1;
		if (d == 0) {
			new_r = r;
			new_c = c - 1;
		}
		if (d == 1) {
			new_r = r - 1;
			new_c = c;
		}
		if (d == 2) {
			new_r = r;
			new_c = c + 1;
		}
		if (d == 3) {
			new_r = r + 1;
			new_c = c;
		}
		if (dep == 4) {
			if (d == 0) {
				new_r = r + 1;
				new_c = c;
			}
			if (d == 1) {
				new_r = r;
				new_c = c - 1;
			}
			if (d == 2) {
				new_r = r - 1;
				new_c = c;
			}
			if (d == 3) {
				new_r = r;
				new_c = c + 1;
			}
			if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m) {
				if (g[new_r][new_c] != 1) {
					dep = 0;
					dfs(new_r, new_c, d, dep);
				}
			}
			return;
		}
		if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m) {
			if (g[new_r][new_c] == 0) {
				dep = 0;
				dfs(new_r, new_c, new_d, dep);
			} else {
				dfs(r, c, new_d, dep + 1);
			}
		} else {
			dfs(r, c, new_d, dep + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n][m];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		dfs(r, c, d, 0);
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] == 2) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}