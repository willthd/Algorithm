package practice;

import java.util.*;

// codeUp, 3740, 배낭 문제
// 동전1과 비슷
// dp[n][w] : n개로 무게 w이하를 만들 수 있는 물건들의 최대 가치
// 얘는 초기화 필요 없네?
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int dp[][] = new int[n + 1][w + 1];
		int wt[] = new int[n + 1];
		int v[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wt[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j - wt[i] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i]] + v[i]);					
				}
			}
		}
		System.out.println(dp[n][w]);
	}
}
