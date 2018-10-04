package practice;

import java.util.*;

public class Main4 {
	static int m, n, h, g[][][], d[][][];
	static boolean v[][][];
	
	public static boolean check() {
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					if (g[z][x][y] == 0 && d[z][x][y] == 0) {
						return false;
					}					
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		g = new int[h][n][m];
		v = new boolean[h][n][m];
		d = new int[h][n][m];
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					g[z][x][y] = sc.nextInt();
				}
			}
		}
		int dx[] = {1, 0, -1, 0, 0, 0};
		int dy[] = {0, 1, 0, -1, 0, 0};
		int dz[] = {0, 0, 0, 0, 1, -1};
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qz = new LinkedList<>();
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					if (g[z][x][y] == 1) {
						qx.add(x);
						qy.add(y);
						qz.add(z);
						v[z][x][y] = true;
					}
				}
			}
		}
		while(!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			int nowz = qz.poll();
			for (int k = 0; k < 6; k++) {
				int nextx = nowx + dx[k];
				int nexty = nowy + dy[k];
				int nextz = nowz + dz[k];
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m || nextz < 0 || nextz >= h) {
					continue;
				}
				if (v[nextz][nextx][nexty]) {
					continue;
				}
				if (g[nextz][nextx][nexty] == -1 || g[nextz][nextx][nexty] == 1) {
					continue;
				}
				qx.add(nextx);
				qy.add(nexty);
				qz.add(nextz);
				v[nextz][nextx][nexty] = true;
				d[nextz][nextx][nexty] = d[nowz][nowx][nowy] + 1;
			}
		}
//		for (int z = 0; z < h; z++) {
//			for (int x = 0; x < n; x++) {
//				for (int y = 0; y < m; y++) {
//					System.out.print(d[z][x][y] + " ");					
//				}
//				System.out.println();
//			}
//		}
		int max = Integer.MIN_VALUE;
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					max = Math.max(max, d[z][x][y]);
				}
			}
		}
		if (check()) {
			System.out.println(max);
		} else {
			System.out.println("-1");
		}
	}
}
	
