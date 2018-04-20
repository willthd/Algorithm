package practice;

import java.util.*;

// 백준, 14889, 스타트와 링크
// 이 문제에서 dfs의 가장 이상적인 구조를 찾을 수 있었다
// dfs method내의 for문 및 if문(return)을 잘 기억해둘것
public class Main{
	static int n, grid[][], min = Integer.MAX_VALUE;
	static boolean visited[];

	public static void dfs(int index, int cnt){
		if (cnt == n / 2){
			int start = 0, link = 0;

			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					if (visited[i] && visited[j]) {
						start += grid[i][j];
					}
					else if (!visited[i] && !visited[j])	{
						link += grid[i][j];
					}
				}
			}

			min = Math.min(min, Math.abs(start - link));
			return;
		}

		for(int i = index; i < n; i++){
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[]ar){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}
}
