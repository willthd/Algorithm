package practice;

import java.util.*;

// 백준, 11724, 연결 요소의 개수
public class Main7 {
	static int n, e, g[][], cnt;
	static boolean visited[];
	
	public static void dfs(int a) {
		visited[a] = true;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			if (g[a][i] == 0) {
				continue;
			}
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		g = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		cnt = 0;
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a][b] = 1;
			g[b][a] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}
}
