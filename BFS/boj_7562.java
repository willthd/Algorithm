package practice;

import java.util.*;

// 백준, 7562, 나이트의 이동
public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			boolean visited[][] = new boolean[n][n];
			int dist[][] = new int[n][n];
			int dx[] = {-2, 2, -2, 2, -1, 1, -1, 1};
			int dy[] = {1, 1, -1, -1, 2, 2, -2, -2};
			int stx = sc.nextInt();
			int sty = sc.nextInt();
			int tax = sc.nextInt();
			int tay = sc.nextInt();
			Queue<Integer> qx = new LinkedList<>();
			Queue<Integer> qy = new LinkedList<>();
			qx.add(stx);
			qy.add(sty);
			visited[stx][sty] = true;
			while (!qx.isEmpty()) {
				int nowx = qx.poll();
				int nowy = qy.poll();
				for (int i = 0; i < 8; i++) {
					int nextx = nowx + dx[i];
					int nexty = nowy + dy[i];
					if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= n) {
						continue;
					}
					if (visited[nextx][nexty]) {
						continue;
					}
					qx.add(nextx);
					qy.add(nexty);
					visited[nextx][nexty] = true;
					dist[nextx][nexty] = dist[nowx][nowy] + 1;
				}
			}
			System.out.println(dist[tax][tay]);
		}
	}
}
