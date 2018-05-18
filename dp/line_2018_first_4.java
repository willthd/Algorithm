package practice;

import java.util.*;

// 라인, 4, 조합
public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			long dp[][] = new long[n + 1][k + 1];
			for (int i = 0; i <= n; i++) {
				dp[i][0] = 1;
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
				}
			}
			System.out.println(dp[n][m] * dp[n][k - m]);
		}
	}
}
