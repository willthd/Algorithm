package practice;

import java.util.*;

// 백준, 1260, BFS와 DFS
// BFS와 DFS for문 내 구조 같다. 다만 BFS는 q를 이용하고, DFS는 재귀 호출을 할 뿐
public class Main4 {
	static int g[][], n, start;
	static boolean visited[];
	
	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= n; i++) {
			if (g[start][i] == 0) {
				continue;
			}
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		int e = sc.nextInt();
		start = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			g[r][c] = g[c][r] = 1;
		}
		dfs(start);
		System.out.println();
		visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			for (int i = 1; i <= n; i++) {
				if (g[now][i] == 0) {
					continue;
				}
				if (visited[i]) {
					continue;
				}
				q.add(i);
				visited[i] = true;
			}
		}
	}
}