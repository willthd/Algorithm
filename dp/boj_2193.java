package practice;

import java.util.*;

// 백준, 이친수, 2193
public class Main6 {
	static long dp[];
	
	// topDown
	static long func(int num) {
		if (dp[num] != -1) {
			return dp[num];
		}
		if (num <= 1) {
			dp[num] = num;
			return dp[num];
		}
		dp[num] = func(num -1) + func(num - 2);
		return dp[num];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1];
		Arrays.fill(dp, -1);
		func(n);
//		bottomUp
//		for (int i = 0; i <= n; i++) {
//			if (i <= 1) {
//				dp[i] = i;
//				continue;
//			}
//			dp[i] = dp[i - 1] + dp[i - 2];
//		}
		System.out.println(dp[n]);
	}
}
