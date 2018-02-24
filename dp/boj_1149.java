package practice;

import java.util.Scanner;

// RGB 거리
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[][] grid = new int[input + 1][3 + 1];
		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= 3; j++) {
				grid[i][j] = sc.nextInt();
			} 
		}
		int[][] dp = new int[input + 1][3 + 1];
		for (int i = 1; i <= 3; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= input; i++) {
			dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + grid[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + grid[i][2];
			dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + grid[i][3];
		}
		System.out.println(Math.min(Math.min(dp[input][1], dp[input][2]), dp[input][3]));
	}
}
