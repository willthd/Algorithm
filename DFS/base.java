package practice;

import java.util.*;

// dp[n][w] : n개로 w무게 이하 만큼 넣을 수 있는 최대 가치
public class Base {
	static int n, g[][], dist[][];
	static boolean visited[][];

	static void dfs(int x, int y) {
		int dx[] = {0, 1, 0, -1};
		int dy[] = {-1, 0, 1, 0};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if (g[nx][ny] == 0) {
				continue;
			}
			visited[nx][ny] = true;
			if (dist[nx][ny] == 0) {
				dist[nx][ny] = dist[x][y] + 1;
			} else {
				dist[nx][ny] = Math.min(dist[x][y] + 1, dist[nx][ny]);
			}
			dfs(nx, ny);
			visited[nx][ny] = false;
		}
	}

	public static void main(String[] ags) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][n];
		dist = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		visited[0][0] = true;
		dist[0][0] = 1;
		dfs(0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}
