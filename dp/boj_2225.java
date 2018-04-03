
package practice;

import java.util.*;

// 백준, 2225, 합분해
// 점화식 구하기 어렵다...
// dp [n][k] : 0부터 n까지의 수 k개를 더해 n을 만들 수 있는 경우의 수
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long dp[][] = new long[n + 1][k + 1];
		for (int i = 1; i <= k; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] += (dp[i - 1][j - l]) % (int) 1e9;
				}
			}
		}
		System.out.println(dp[n][k] % (int) 1e9);
	}
}