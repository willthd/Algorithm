package practice;

import java.util.*;

// 백준, 11057, 오르막수
// dp[n][k] : n자리 중에서 마지막 수가 k로 끝나는 오르막수의 개수
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[1000 + 1][10];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				long sum = 0;
				for (int k = 0; k <= j; k++) {
					sum += dp[i - 1][k] % 10007;
				}
				dp[i][j] = sum % 10007;
			}
		}
		long result = 0;
		for (int i = 0; i<= 9; i++) {
			result += dp[n][i] % 10007;
		}
		System.out.println(result % 10007);
	}
}
