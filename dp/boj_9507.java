
package practice;

import java.util.*;

// 백준, 9507, Generations of Tribbles
// dp[i] = 문제에서 정의된 피보나치의 i일 때 값
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			long dp[] = new long[n + 1];
			for (int i = 0; i <= n; i++) {
				if (i < 2) {
					dp[i] = 1;
				}
				if (i == 2) {
					dp[i] = 2;
				}
				if (i == 3) {
					dp[i] = 4;
				}
				if (i > 3) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
				}
			}
			System.out.println(dp[n]);
		}
	}
}