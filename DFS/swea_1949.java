package practice;
import java.util.*;

// SWEA, 1949, 등산로 조성
// dfs가 더 적합하다
// 조건의 최대값으로 다 돌려도 1억 넘지 않아서 시간 초과 되지 않는다
// 처음엔 벽 부수고 이동하기 문제처럼 dist[][][] 배열을 이용해서 풀었는데, 테스트 케이스가 몇 개 틀렸고, 반례를 찾는데 시간이 오래걸려서
// 다 돌려보는 방식으로 변형하여 풀었다
// dfs에서 visited부분 주의한다
public class Main4 {
	static int n, g[][], k, max2;
	static boolean visited[][];

	static void dfs(int x, int y, int depth) {
		max2 = Math.max(max2, depth);
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			if (nextx < 0 || nextx >= n || nexty < 0 || nexty >Main4.java= n) {
				continue;
			}
			if (visited[nextx][nexty]) {
				continue;
			}
			if (g[x][y] <= g[nextx][nexty]){
				continue;
			}
			// 주의 !!
			// 단지 같은 문제는 어떤 경로든 그 위치 가면 같은 경우라 생각해도 무방하지만, 여기선 해당 위치에 다른 경로로 가면 다른 경로로 생각해야 한다
			visited[nextx][nexty] = true;
			dfs(nextx, nexty, depth + 1);
			visited[nextx][nexty] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			g = new int[n][n];
			k = sc.nextInt();
			max2 = 0;
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g[i][j] = sc.nextInt();
					max = Math.max(max, g[i][j]);
				}
			}
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					if (max == g[b][c]) {
						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) {
								for (int m = 1; m <= k; m++) {
									g[i][j] -= m;
									visited = new boolean[n][n];
									visited[b][c] = true;
									dfs(b, c, 1);
									g[i][j] += m;
								}
							}
						}

					}
				}
			}
			System.out.println("#" + tc + " " + max2);
		}
	}
}
