package practice;

import java.util.*;

public class Main4 {
	static int m, n, g[][], d[][];
	static boolean v[][];
	
	public static boolean check() {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if (g[x][y] == 0 && d[x][y] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		g = new int[n][m];
		v = new boolean[n][m];
		d = new int[n][m];
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <m; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] == 1) {
					qx.add(i);
					qy.add(j);
					v[i][j] = true;
				}
			}
		}
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
				if (g[nextx][nexty] == -1 || g[nextx][nexty] == 1) {
					continue;
				}
				qx.add(nextx);
				qy.add(nexty);
				v[nextx][nexty] = true;
				d[nextx][nexty] = d[nowx][nowy] + 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, d[i][j]);
			}
		}
		if (check()) {
			System.out.println(max);
		} else {
			System.out.println("-1");
		}
	}
}
	
