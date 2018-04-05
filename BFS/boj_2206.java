package practice;

import java.util.*;

// 백준, 2206, 벽 부수고 이동하기
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g[][] = new int[n][m];
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		int dist[][][] = new int[n][m][2];
		boolean visited[][][] = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				g[i][j] = s.charAt(j) - 48;
			}
		}
		int stx = 0;
		int sty = 0;
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qcr = new LinkedList<>();
		qx.add(stx);
		qy.add(sty);
		qcr.add(0);
		visited[stx][sty][0] = true;
		visited[stx][sty][1] = true;
		dist[stx][sty][0] = 1;
		dist[stx][sty][1] = 1;
		dist[n - 1][m - 1][0] = (int) 1e9;
		dist[n - 1][m - 1][1] = (int) 1e9;
		while (!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			int nowcr = qcr.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				if (visited[nextx][nexty][nowcr]) {
					continue;
				}
				if (g[nextx][nexty] == 0) {
					visited[nextx][nexty][nowcr] = true;
					qx.add(nextx);
					qy.add(nexty);
					qcr.add(nowcr);
					dist[nextx][nexty][nowcr] = dist[nowx][nowy][nowcr] + 1;
				}
				if (g[nextx][nexty] == 1 && nowcr == 0) {
					visited[nextx][nexty][1] = true;
					qx.add(nextx);
					qy.add(nexty);
					qcr.add(1);
					dist[nextx][nexty][1] = dist[nowx][nowy][0] + 1;
				}
			}
			for (int k = 0; k < 2; k++) {
				System.out.println(k + 1);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						System.out.print(dist[i][j][k] + " ");
					}
					System.out.println();
				}
				System.out.println("******");
			}
		}
		if (dist[n - 1][m - 1][0] == (int) 1e9 && dist[n - 1][m - 1][1] == (int) 1e9) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]));			
		}
	}
}