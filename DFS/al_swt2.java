
import java.util.*;

public class ppp {
	static int n, m, g[][], max, cnt;
	static boolean check[], visited[][];
	
	static void dfs(int x, int y, int sum) {
		if (visited[n - 1][m - 1]) {
			max = Math.max(max, sum);
			cnt++;
		}
		int dx[] = {1, 0};
		int dy[] = {0, 1};
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if (check[g[nx][ny]]) {
				continue;
			}
			// 여기서 이거 꼭 해줘야 한다 !
			visited[nx][ny] = true;
			check[g[nx][ny]] = true;
			dfs(nx, ny, sum + g[nx][ny]);
			// dfs 끝나고 다시 돌아오는 위치가 이곳
			// 돌아왔으니까 가장 최근에 visited배열과 check배열에서 true해준 것 false로 바꿔준다
			visited[nx][ny] = false;
			check[g[nx][ny]] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			g = new int[n][m];
			max = 0;
			cnt = 0;
			visited = new boolean[n][m];
			check = new boolean[201];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			// 처음 값을 꼭 여기서 넣어준다
			visited[0][0] = true;
			check[g[0][0]] = true;
			dfs(0, 0, g[0][0]);
			if (cnt == 0) {
				System.out.println("#" + tc + " 0 -1");
			} else {
				System.out.println("#" + tc + " " + cnt + " " + max);				
			}
		}
	}
}
