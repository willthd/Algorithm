package practice;

import java.util.*;

// 백준, 9252, LCS2
// dp[i][j] : 첫번째 문자열은 i번째 문자, 두번째 문자열은 j번째 문자일 때, 가장 긴 공통 부분 문자열 
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int n1 = s1.length();
		int n2 = s2.length();
		String dp[][] = new String[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			Arrays.fill(dp[i], "");
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = (dp[i - 1][j - 1] + s1.charAt(i - 1));
				} else {
					if ((dp[i][j - 1]).length() > (dp[i - 1][j]).length()) {
						dp[i][j] = dp[i][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		System.out.println((dp[n1][n2]).length());
		System.out.println(dp[n1][n2]);
	}
}