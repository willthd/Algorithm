package practice;

import java.util.*;

// 백준, 2133, 타일 채우기
// dp[i] : 타일 길이 i일 때, 만들 수 있는 개수
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long[n + 1];
		for (int i = 0; i <= n; i = i + 2) {
			if (i == 0) {
				dp[i] = 1;
			} else if (i == 2) {
				dp[i] = 3;
			} else {
				dp[i] = dp[i - 2] * 3;
				for (int j = 4; j <= i; j = j + 2) {
					dp[i] += dp[i - j] * 2;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
