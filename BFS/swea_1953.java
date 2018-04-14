package practice;

import java.util.*;

// SWEA, 1953, 탈주범 검거
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int g[][] = new int[n][m];
			int dist[][] = new int[n][m];
			int dx[] = { 0, 1, 0, -1 };
			int dy[] = { 1, 0, -1, 0 };
			boolean visited[][] = new boolean[n][m];
			int cnt = 0;
			int c = sc.nextInt();
			int r = sc.nextInt();
			int l = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			visited[c][r] = true;
			dist[c][r] = 1;
			Queue<Integer> qx = new LinkedList<>();
			Queue<Integer> qy = new LinkedList<>();
			qx.add(c);
			qy.add(r);
			while (!qx.isEmpty()) {
				int x = qx.poll();
				int y = qy.poll();
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					if (visited[nx][ny]) {
						continue;
					}
					if (i == 0) {
						if (g[x][y] == 1 || g[x][y] == 3 || g[x][y] == 4 || g[x][y] == 5) {
							if (g[nx][ny] == 1 || g[nx][ny] == 3 || g[nx][ny] == 6 || g[nx][ny] == 7) {
								qx.add(nx);
								qy.add(ny);
								visited[nx][ny] = true;
								dist[nx][ny] = dist[x][y] + 1;
							}
						}
					}
					if (i == 1) {
						if (g[x][y] == 1 || g[x][y] == 2 || g[x][y] == 5 || g[x][y] == 6) {
							if (g[nx][ny] == 1 || g[nx][ny] == 2 || g[nx][ny] == 4 || g[nx][ny] == 7) {
								qx.add(nx);
								qy.add(ny);
								visited[nx][ny] = true;
								dist[nx][ny] = dist[x][y] + 1;
							}
						}
					}
					if (i == 2) {
						if (g[x][y] == 1 || g[x][y] == 3 || g[x][y] == 6 || g[x][y] == 7) {
							if (g[nx][ny] == 1 || g[nx][ny] == 3 || g[nx][ny] == 4 || g[nx][ny] == 5) {
								qx.add(nx);
								qy.add(ny);
								visited[nx][ny] = true;
								dist[nx][ny] = dist[x][y] + 1;
							}
						}
					}
					if (i == 3) {
						if (g[x][y] == 1 || g[x][y] == 2 || g[x][y] == 4 || g[x][y] == 7) {
							if (g[nx][ny] == 1 || g[nx][ny] == 2 || g[nx][ny] == 5 || g[nx][ny] == 6) {
								qx.add(nx);
								qy.add(ny);
								visited[nx][ny] = true;
								dist[nx][ny] = dist[x][y] + 1;
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] && dist[i][j] <= l) {
						cnt++;
					}
				}
			}
			System.out.println("#"  + tc + " " + cnt);
		}
	}
}