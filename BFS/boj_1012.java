package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int l = sc.nextInt();
			int g[][] = new int[n][m];
			int d[][] = new int[n][m];
			boolean v[][] = new boolean[n][m];
			for (int i = 0; i < l; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				g[b][a] = 1;
			}
			int cnt = 1;
			int dx[] = {1, 0, -1, 0};
			int dy[] = {0, 1, 0, -1};
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (g[i][j] == 0) {
						continue;
					}
					if (v[i][j]) {
						continue;
					}
					
					Queue<Integer> qx = new LinkedList<>();
					Queue<Integer> qy = new LinkedList<>();
					qx.add(i);
					qy.add(j);
					v[i][j] = true;
					d[i][j] = cnt;
					while(!qx.isEmpty()) {
						int nowx = qx.poll();
						int nowy = qy.poll();
						for (int k = 0; k < 4; k++) {
							int nextx = nowx + dx[k];
							int nexty = nowy + dy[k];
							if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
								continue;
							}
							if (v[nextx][nexty]) {
								continue;
							}
							if (g[nextx][nexty] == 0) {
								continue;
							}
							qx.add(nextx);
							qy.add(nexty);
							v[nextx][nexty] = true;
							d[nextx][nexty] = cnt;
						}
					}
					cnt++;
				}
			}
			System.out.println(cnt - 1);
		}
	}
}
	
