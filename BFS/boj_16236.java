package practice;

import java.util.*;

public class Main5 {
	static int n, g[][], d[][], size;
	static boolean v[][];
	public static void bfs(int x, int y) {
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(x);
		qy.add(y);
		v[x][y] = true;
		while(!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx >= n|| nexty < 0 || nexty >= n) {
					continue;
				}
				if (v[nextx][nexty]) {
					continue;
				}
				if (g[nextx][nexty] > size) {
					continue;
				}
				qx.add(nextx);
				qy.add(nexty);
				v[nextx][nexty] = true;
				d[nextx][nexty] = d[nowx][nowy] + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][n];
		v = new boolean[n][n];
		d = new int[n][n];
		int stx = -1;
		int sty = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 9) {
					stx = i;
					sty = j;
					g[i][j] = 0;
				}
			}
		}
		size = 2;
		bfs(stx, sty);
		List<Fish> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] < size && g[i][j] != 0 && d[i][j] != 0) {
					list.add(new Fish(i, j));
				}
			}
		}
		int eating = 0;
		int result = 0;
		while(!list.isEmpty()) {
			int min = Integer.MAX_VALUE;
			int target_x = -1;
			int target_y = -1;
			int index = -1;
			for (int i = 0; i < list.size(); i++) {
				int fish_x = list.get(i).x;
				int fish_y = list.get(i).y;
				int dist = d[fish_x][fish_y];
				if (min > dist) {
					target_x = fish_x;
					target_y = fish_y;
					min = dist;
					index = i;
				}
			}
			list.remove(index);
			eating++;
			g[target_x][target_y] = 0;
			result += d[target_x][target_y];
			if (eating == size) {
				eating = 0;
				size++;
				v = new boolean[n][n];
				d = new int[n][n];
				bfs(target_x, target_y);
				list = new LinkedList<>();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (g[i][j] < size && g[i][j] != 0 && d[i][j] != 0) {
							list.add(new Fish(i, j));
						}
					}
				}
			}
			v = new boolean[n][n];
			d = new int[n][n];
			bfs(target_x, target_y);
		}
		System.out.println(result);
	}
}

class Fish {
	int x;
	int y;
	
	Fish(int x, int y) {
		this.x = x;
		this.y = y;
	}
}