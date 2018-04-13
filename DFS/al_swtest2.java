import java.util.*;

// 출근
// bfs로 풀면 굉장히 복잡해진다
public class Main4 { 
	static int n, m, g[][], max, cnt, check[];
	static boolean visited[][];

	static void dfs(int x, int y, int sum) {
		if (visited[n - 1][m - 1]) {
			cnt++;
			max = Math.max(max, sum);
		}
		int dx[] = { 1, 0 };
		int dy[] = { 0, 1 };
		for (int i = 0; i < 2; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
				continue;
			}
			if (visited[nextx][nexty]) {
				continue;
			}
			if (check[g[nextx][nexty]] == 1) {
				continue;
			}
			visited[nextx][nexty] = true;
			check[g[nextx][nexty]] = 1;
			dfs(nextx, nexty, sum + g[nextx][nexty]);
			visited[nextx][nexty] = false;
			check[g[nextx][nexty]] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			g = new int[n][m];
			check = new int[201];
			max = 0;
			cnt = 0;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			visited[0][0] = true;
			check[g[0][0]] = 1;
			dfs(0, 0, g[0][0]);
			if (cnt == 0) {
				System.out.println("#" + tc + " 0 -1");
			} else {
				System.out.println("#" + tc + " " + cnt + " " + max);
			}
		}
	}
}
