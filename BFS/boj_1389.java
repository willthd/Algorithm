package practice;

import java.util.*;

// 1260, BFS와 DFS 문제와 비슷
public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g[][] = new int[n][n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a - 1][b - 1] = 1;
			g[b - 1][a - 1] = 1;
		}
		int min = Integer.MAX_VALUE;
		int result = -1;
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			boolean visited[] = new boolean[n];
			int d[] = new int[n];
			q.add(i);
			visited[i] = true;
			while(!q.isEmpty()) {
				int now = q.poll();
				for (int k = 0; k < n; k++) {
					if (visited[k]) {
						continue;
					}
					if (g[now][k] == 0) {
						continue;
					}
					q.add(k);
					visited[k] = true;
					d[k] = d[now] + 1;
				}
			}
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				cnt += d[j];
			}
			if (min > cnt) {
				min = cnt;
				result = i;
			}
		}
		System.out.println(result + 1);
	}
}
