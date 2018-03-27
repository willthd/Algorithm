package practice;

import java.util.*;

// 백준, 2606, 바이러스 (dfs)
public class Main4 {
	static int n, g[][];
	static boolean visited[];

	static void dfs(int x) {
		visited[x] = true;
		for (int i = 0; i < n + 1; i++) {
			if (g[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			g[r][c] = g[c][r] = 1;
		}
		dfs(1);
		int cnt = 0;
		for (int i = 0; i < n + 1; i++) {
			if (visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt - 1);
	}
}