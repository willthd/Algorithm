package practice;

import java.util.*;

// 백준, 2178, 미로탐색  
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g[][] = new int[n][m];
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		int dist[][] = new int[n][m];
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				g[i][j] = s.charAt(j) - 48;
			}
		}
		int stx = 0;
		int sty = 0;
		Deque<Integer> qx = new ArrayDeque<>();
		Deque<Integer> qy = new ArrayDeque<>();
		qx.add(stx);
		qy.add(sty);
		visited[stx][sty] = true;
		dist[stx][sty] = 1;
		while (!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			if (nowx == n - 1 && nowy == m - 1) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				if (g[nextx][nexty] == 0) {
					continue;
				}
				if (visited[nextx][nexty]) {
					continue;
				}
				visited[nextx][nexty] = true;
				qx.add(nextx);
				qy.add(nexty);
				dist[nextx][nexty] = dist[nowx][nowy] + 1;
			}
		}
		System.out.println(dist[n - 1][m - 1]);
	}
}
