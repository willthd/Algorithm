package practice;

import java.util.*;

// 백준, 9251, LCS
//dp[i][j] : 첫번째 문자열이 i번째, 두번째 문자열이 j번째일 때, 최장 공통 부분 수열 길이  
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int n = s1.length();
		int m = s2.length();
		long dp[][] = new long[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
