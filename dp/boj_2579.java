package practice;

import java.util.*;

// 백준, 2579, 계단 오르기
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int steps[] = new int[n];
		int dp[][] = new int[n][2];
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			steps[i] = sc.nextInt();
		}
//		1번 방법(d[]이 꼭 2차원 배열일 필요 있을까? 바로 뒤 계단 사용하느냐 안하느냐를 확인하기 위해 넣긴 했지만 -> 2번 방법)
//		dp[0][0] = steps[0];
//		dp[0][1] = steps[0];
//		dp[1][0] = steps[0] + steps[1];
//		dp[1][1] = steps[1];
//		for (int i = 2; i < n; i++) {
//			dp[i][0] = dp[i - 1][1] + steps[i];
//			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + steps[i];
//		}
//		for (int i = 1; i <= n; i++) {
//			System.out.println(Math.max(dp[i - 1][0], dp[i - 1][1]));			
//		}
		
//		2번 방법
		d[0] = 10;
		d[1] = 30;
		d[2] = 35;
		for (int i = 3; i < n; i++) {
			d[i] = Math.max(d[i - 2] + steps[i], d[i - 3] + steps[i - 1] + steps[i]);		
		}
		for (int i = 0; i < n; i++) {
			System.out.println(d[i]);
		}
	}
}
