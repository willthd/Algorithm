package practice;

import java.util.*;

// bruteForce, 조합
public class Main6 {
	static int n, m, g[][], g_copy[][], max = Integer.MIN_VALUE;
	static boolean v[][];

	public static void f(int dep, int st) {
		if (dep == 3) {
			g_copy = new int[n][m];
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					g_copy[i][j] = g[i][j];

				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (g_copy[i][j] == 2) {
						dfs(i,j);
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (g_copy[i][j] == 0) {
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
			return;
		}
		// 완전 탐색이기는 하나, 중복되는 경우 있다.
		// 다만 시간복잡도에서 벗어날 수준은 아니다.
		for (int i = st; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] != 0) {
					continue;
				}
				g[i][j] = 1;
				f(dep + 1, i);
				g[i][j] = 0;
			}
		}
	}

	public static void dfs(int x, int y) {
		v[x][y] = true;
		g_copy[x][y] = 2;
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
				continue;
			}
			if (g_copy[nextx][nexty] != 0) {
				continue;
			}
			if (v[nextx][nexty]) {
				continue;
			}
			dfs(nextx, nexty);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n][m];
		int stx = -1;
		int sty = -1;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 2) {
					if (flag) {
						stx = i;
						sty = j;
						flag = false;
					}
				}
			}
		}
		f(0, 0);
		System.out.println(max);
	}
}
