package practice;

import java.util.*;

// 백준, 11727, 2xn 타일링 2
// dp[n] : 2xn을 2x1, 2x2로 만들 수 있는 경우의 수
// 초기화 필요하다
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = 1;
			} else if (i == 2) {
				dp[i] = 3;
			} else {
				dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;				
			}
		}
		System.out.println(dp[n]);
	}
}
