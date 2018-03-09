package practice;

import java.util.*;

// 백준, 2583, 영역 구하기
// 단자 번호 붙이기랑 똑같은 문제라 쉽게 구할 수 있었다. 하지만 조금 헷갈렸던 부분은 좌표로 나와 있는 것을 행렬로 표기해야 되는것
// 이 부분을 시험에서 봤다면 당황했을 수도 있을 것 같다. 미리 경험해보길 잘했다. 변환 해보니 좌표 값을 원하는 행렬로 그대로 표기하는 것은 어렵다
// 다만 blob 개수와 cell 개수만 출력하면 되기 때문에 상하 반전된 형태에서 값을 구했다
public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int m = sc.nextInt();
	static int n = sc.nextInt();
	static int k = sc.nextInt();
	static int[][] grid = new int[m][n];
	static boolean[][] visited = new boolean[m][n];
	static List<Integer> values = new ArrayList<>();

	static int dfs(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return 0;
		} else if (visited[x][y]) {
			return 0;
		} else if (grid[x][y] == 1) {
			return 0;
		} else {
			visited[x][y] = true;
			return 1 + dfs(x - 1, y) + dfs(x + 1, y) + dfs(x, y - 1) + dfs(x, y + 1);
		}

	}

	public static void main(String[] args) {
		grid = new int[m][n];
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					grid[j][k] = 1;
				}
			}
		}
		// 여기선 m, n 순서를 바꿀 필요없다
		for (int i = 0 ; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && !visited[i][j]) {
					values.add(dfs(i, j));
				}
			}
		}

		Collections.sort(values);
		System.out.println(values.size());
		for (int i = 0; i < values.size(); i++) {
			System.out.print(values.get(i) + " ");
		}
	}
}
