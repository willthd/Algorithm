package practice;

import java.util.*;

// 백준, 11403, 경로찾기 (bfs)
public class Main4 {
	static int n, g[][];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			visited = new boolean[n];
			while(!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < n; j++) {
					if (g[now][j] == 0) {
						continue;
					}
					if (visited[j]) {
						continue;
					}
					q.add(j);
					// 여기다가 true해야 한다
					visited[j] = true;
				}
			}
			for (int j = 0; j < n; j++) {
				if (visited[j]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}
}
