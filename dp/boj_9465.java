package practice;

import java.util.*;

// 백준, 9465, 스티커
// dp[n][k] : n번째 줄에서 k행에 있는 스티커를 선택할 때 최대 가치
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int sti[][] = new int[2 + 1][n + 1];
			int dp[][] = new int[n + 1][2 + 1];
			for (int i = 1; i <= 2; i++) {
				for (int j = 1; j <= n; j++) {
					sti[i][j] = sc.nextInt();
				}
			}
			for (int i = 1; i <= 2; i++) {
				dp[1][i] = sti[i][1];
			}
			for (int i = 2; i <= n; i++) {
				dp[i][1] = Math.max(dp[i - 1][2], dp[i - 2][2]) + sti[1][i];
				dp[i][2] = Math.max(dp[i - 1][1], dp[i - 2][1]) + sti[2][i];
			}
			System.out.println(Math.max(dp[n][1], dp[n][2]));
		}
	}
}
