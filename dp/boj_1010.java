package practice;

import java.util.*;

// 백준, 1010, 다리 놓기
// 재귀 -> 시간 초과 -> DP !
// 조합은 점화식 있다 그것 이용했음
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int r = sc.nextInt();
			int n = sc.nextInt();
			int dp[][] = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				dp[i][0] = dp[i][i] = 1;
				dp[i][1] = i;
			}
			for (int i = 1; i <= r; i++) {
				for (int j = i + 1; j <= n; j++) {
					dp[j][i] = dp[j - 1][i - 1] + dp[j - 1][i];					
				}
			}
			System.out.println(dp[n][r]);
		}
	}
}