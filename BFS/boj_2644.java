package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int g[][] = new int[n][n];
		int d[][] = new int[n][n];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			g[t1 - 1][t2 - 1] = 1;
			g[t2 - 1][t1 - 1] = 1;
		}
		for (int j = 0; j < n; j++) {
			Queue<Integer> q = new LinkedList<>();
			boolean visited[] = new boolean[n];
			q.add(j);
			visited[j] = true;
			while(!q.isEmpty()) {
				int now = q.poll();
				for (int i = 0; i < n; i++) {
					if (visited[i]) {
						continue;
					}
					if (g[now][i] == 0) {
						continue;
					}
					q.add(i);
					visited[i] = true;
					d[j][i] = d[j][now] + 1;
				}
			}
		}
		if (d[a - 1][b - 1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(d[a - 1][b - 1]);			
		}
	}
}