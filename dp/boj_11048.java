package practice;

import java.util.*;

// 백준, 11048, 이동하기
// dp[n][m] : (1,1)부터 (n,m)까지 갈 수 있는 방의 최대 사탕 수
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n + 1][m + 1];
		long dp[][] = new long[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
			}
		}
		System.out.println(dp[n][m]);
	}
}
