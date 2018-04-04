package practice;

import java.util.*;

// 백준, 10164, 격자상의 경로
// dp[i][j] : (1,1)부터 (n,m)까지 가는 경로의 수
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[][] = new int[n + 1][m + 1];
		long dp[][] = new long[n + 1][m + 1];
		int cnt = 0;
		int x = 0, y = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = ++cnt;
				if (cnt == k) {
					x = i;
					y = j;
				}
			}
		}
		if (k == 0) {
			x = n;
			y = m;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][1] = 1;
		}
		for (int i = 1; i <= m; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= x; i++) {
			for (int j = 2; j <= y; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		long n1 = dp[x][y];
		for (int i = 2; i <= n - x + 1; i++) {
			for (int j = 2; j <= m - y + 1; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		long n2 = dp[n - x + 1][m - y + 1];
		System.out.println(n1 * n2);
	}
}