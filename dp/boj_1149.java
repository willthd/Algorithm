package practice;

import java.util.*;

// 백준, 1149, RGB거리
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n][3];
		int color[][] = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				color[i][j] = sc.nextInt();
			}			
		}
		for (int i = 0; i < 3; i++) {
			dp[0][i] = color[0][i];
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];	
		}
		int result =Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
		System.out.println(result);
	}
}
