package practice;

import java.util.*;

// 백준, 1699, 제곱수의 합
// dp[i] : 제곱수의 합으로 i를 만들 때, 제곱수의 최소 개수
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			long min = (int) 1e9;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = min;
		}
		System.out.println(dp[n]);
	}
}
