package practice;

import java.util.*;

// BFS, baseCode
// 시작 위치에서 각 위치마다 가는데 필요한 이동 횟수(1로 된 곳만 이동할 수 있음)
public class Main6 {
	static int grid[][];
	static int dist[][];
	static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		grid = new int[n][m];
		// 기준 점으로 부터 거리 차이(시간이 될 수도 있다)
		dist = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		int startx, starty;
		// 방향
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		startx = starty = 1;
		qx.add(startx);
		qy.add(starty);
		dist[startx][starty] = 0;
		// 시작점 true로 시작하는 경우 있고 그렇지 않은 경우 있다
		// 11403 에선 시작점 true하지 않는다
		visited[startx][starty] = true;
		while (!qx.isEmpty()) {
			int nowx = qx.poll();
			int nowy = qy.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				// 조건 3개
				// 범위 벗어난 곳
				if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
					continue;
				}
				// 갈 수 없는 곳
				if (grid[nextx][nexty] == 0) {
					continue;
				}
				// 이미 방문한 곳
				if (visited[nextx][nexty]) {
					continue;
				}
				// 대개 3개. dist값 넣기, visited 배열 true 만들기. q에 다음 값 집어 넣기
				dist[nextx][nexty] = dist[nowx][nowy] + 1;
				visited[nextx][nexty] = true;
				qx.add(nextx);
				qy.add(nexty);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}
