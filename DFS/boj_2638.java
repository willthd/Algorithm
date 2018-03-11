package practice;

import java.util.Arrays;
import java.util.Scanner;

// 백준, 2638, 치즈
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	static int[][] grid = new int[n][m];
	static boolean[][] visited = new boolean[n][m];
	static int cnt = 0;

	static boolean isAllZero() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	// 조건 순서 하나만 달라도 답 안나온다. 정말 신중하게 생각해봐야한다. 이 오류 찾는데 시간 정말 많이 잡아먹었다...
	static void dfs(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= m) {
			return;
		} else if (grid[x][y] != 0) {
			grid[x][y]++;
			return;
		} else if (visited[x][y]) {
			return;
		} else {
			visited[x][y] = true;
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			return;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// 여기선 disolve() 함수가 2중 for문을 돌지 않아도 된다. DFS의 개념은 각 조건에 맞는 경우만을 깊이 우선 탐색 하는데,
		// 여기선 바깥의 0인 조건만 찾으면 되기 때문. 만약 blob의 개수를 구한다던지 할 때는 2중 for문을 돌아야한다
		// 항상 같은 방법이 적용되는 것이 아니기 때문에 문제에 알맞게 생각할 필요가 있다
		while (!isAllZero()) {
			dfs(1, 5);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] >= 3) {
						grid[i][j] = 0;
					} else if (0 < grid[i][j] && grid[i][j] < 3) {
						grid[i][j] = 1;
					}
				}
			}
			cnt++;
			for (boolean[] temp : visited) {
				Arrays.fill(temp, false);
			}
		}
		System.out.println(cnt);
	}
}
