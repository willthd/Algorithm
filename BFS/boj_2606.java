package practice;

import java.util.*;

// 백준, 2606, 바이러스 (bfs)
public class Main4 {
	static int n, g[][];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			// 양방향
			g[r][c] = g[c][r] = 1;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < n + 1; i++) {
				if (g[now][i] == 0) {
          	continue;
        }
        if (visited[i]) {
          	continue;
        }
				visited[i] = true;
				q.add(i);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n + 1; i++) {
			if (visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt - 1);
	}
}
