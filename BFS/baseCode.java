package practice;

import java.util.*;

// BFS, baseCode
public class Main6 {
	static int M[][];
	static int dist[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		M = new int[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				M[i][j] = sc.nextInt();
			}
		}
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		int startx, starty;
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		startx = starty = 1;
		qx.add(startx);
		qy.add(starty);
		dist[startx][starty] = 1;
		while (!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				// 갈 수 없는 곳
				if (M[nextx][nexty] == 0) {
					continue;
				}
				// 이미 방문한 곳
				if (dist[nextx][nexty] != 0) {
					continue;
				}
				dist[nextx][nexty] = dist[nowx][nowy] + 1;
				qx.add(nextx);
				qy.add(nexty);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}
