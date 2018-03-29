package practice;

import java.util.*;

// 백준, 1463, 1로 만들기(topDown)
public class ppp {
	static int[] dp;

	public static int func(int input) {
		if (dp[input] != (int) 1e9) {
			return dp[input];
		}
		if (input == 1) {
			dp[input] = 0;
			return dp[input];
		}
		dp[input] = func(input - 1) + 1;
		if (input % 2 == 0) {
			dp[input] = Math.min(dp[input], func(input / 2) + 1);
		}
		if (input % 3 == 0) {
			dp[input] = Math.min(dp[input], func(input / 3) + 1);
		}
		return dp[input];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];
		Arrays.fill(dp, (int) 1e9);
		func(n);
		System.out.println(dp[n]);
	}
}
