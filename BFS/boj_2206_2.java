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
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		dist[0][0][0] = 1;
		dist[0][0][1] = 1;
		dist[n - 1][m - 1][0] = (int) 1e9;
		dist[n - 1][m - 1][1] = (int) 1e9;
		while (!q.isEmpty()) {
			Node now = q.poll();
			int ck = now.ck;
			for (int i = 0; i < 4; i++) {
				int nextx = now.x + dx[i];
				int nexty = now.y + dy[i];
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				if (visited[nextx][nexty][ck]) {
					continue;
				}
				if (g[nextx][nexty] == 0) {
					visited[nextx][nexty][ck] = true;
					q.add(new Node(nextx, nexty, ck));
					dist[nextx][nexty][ck] = dist[now.x][now.y][ck] + 1;
				}
				if (g[nextx][nexty] == 1 && ck == 0) {
					visited[nextx][nexty][1] = true;
					q.add(new Node(nextx, nexty, 1));
					dist[nextx][nexty][1] = dist[now.x][now.y][0] + 1;
				}
			}
		}
		if (dist[n - 1][m - 1][0] == (int) 1e9 && dist[n - 1][m - 1][1] == (int) 1e9) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]));			
		}
	}
}

class Node {
	int x;
	int y;
	int ck;
	
	Node(int x, int y, int ck) {
		this.x = x;
		this.y = y;
		this.ck = ck;
	}
}