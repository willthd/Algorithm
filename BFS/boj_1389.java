package practice;

import java.util.*;

// 1260, BFS와 DFS 문제와 비슷
public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g[][] = new int[n][n];
		int d[][] = new int[n][n];
		boolean visited[][] = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a - 1][b - 1] = 1;
			g[b - 1][a - 1] = 1;
		}
		int min = Integer.MAX_VALUE;
		int result = -1;
		// 시작 node에 따라서 떨어진 거리 다르기 때문에 for문으로 시작 node 한번씩 돌려본다
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			visited[i][i] = true;
			while(!q.isEmpty()) {
				int now = q.poll();
				for (int k = 0; k < n; k++) {
					if (visited[i][k]) {
						continue;
					}
					if (g[now][k] == 0) {
						continue;
					}
					q.add(k);
					visited[i][k] = true;
					d[i][k] = d[i][now] + 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				cnt += d[i][j];
			}
			if (min > cnt) {
				min = cnt;
				result = i;
			}
		}
		System.out.println(result + 1);
	}
}
