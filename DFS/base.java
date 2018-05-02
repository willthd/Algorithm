package practice;
import java.util.*;

public class Main2 {
	static int n, g[][], dist[][];
	static boolean visited[][];
	
	public static void dfs(int x, int y) {
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if (g[nx][ny] == 0) {
				continue;
			}
			visited[nx][ny] = true;
			dist[nx][ny] = dist[x][y] + 1;
			dfs(nx, ny);
			// 잊지말기
			visited[nx][ny] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][n];
		dist = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		// 여기서 처음 값 설정
		visited[0][0] = true;
		dist[0][0] = 1;
		dfs(0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}