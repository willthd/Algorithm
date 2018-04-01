package practice;

import java.util.*;

// 백준, 9461, 파도반 수열
// dp[n] : n번째 삼각형의 변의 길이
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			long dp[] = new long[100 + 1];
			for (int i = 1; i <= n; i++) {
				if (i <= 3) {
					dp[i] = 1;
				} else if (i <= 5) {
					dp[i] = 2;
				} else {
					dp[i] = dp[i - 1] + dp[i - 5];					
				}
			}
			System.out.println(dp[n]);
		}
	}
}
