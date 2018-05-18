package practice;

import java.util.*;

// 라인, 3, 백준 11724와 비슷
public class Main7 {
	static int n, node[], g[][], cnt;
	static boolean visited[];
	
	public static void dfs(int a) {
		for (int i = 1; i <= 10000; i++) {
			if (visited[i]) {
				continue;
			}
			if (g[a][i] == 0) {
				continue;
			}
			visited[a] = true;
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[10001][10001];
		node = new int[10001];
		visited = new boolean[10001];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a][b] = 1;
			g[b][a] = 1;
			node[a] = 1;
			node[b] = 1;
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (visited[i]) {
				continue;
			}
			if (node[i] == 0) {
				continue;
			}
			cnt++;
			visited[i] = true;
			dfs(i);
		}
		System.out.println(cnt);
	}
}
