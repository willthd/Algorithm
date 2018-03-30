package practice;

import java.util.*;

// 백준, 11052, 붕어빵 판매하기
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		int v[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			v[i] = sc.nextInt();
		}
		dp[1] = v[1];
		for (int i = 2; i <= n; i++) {
			int max = -1;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max, dp[i - j] + v[j]);				
			}
			dp[i] = max;
		}
		System.out.println(dp[n]);
	}
}