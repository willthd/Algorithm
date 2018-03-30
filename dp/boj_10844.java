package practice;

import java.util.*;

// 백준, 10844, 쉬운 계단 수
// dp[n][l] : n자리 수 중 l로 끝나는 수의 개수
// int 범위 넘어갈 수 있다 -> long
// 나눈 값을 출력하는 경우 매번 저장할 때 나눈 값을 저장한다
// 이 경우는 최종적으로 sum을 또 한번 나눠줘야 한다
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[n + 1][10];
		dp[1][0] = 0;
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1] % (int) 1e9;
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % (int) 1e9;
			}
			dp[i][9] = dp[i - 1][8] % (int) 1e9;
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % (int) 1e9);
	}
}