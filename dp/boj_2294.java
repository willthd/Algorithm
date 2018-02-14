package practice;

import java.util.Arrays;
import java.util.Scanner;

// 동전2. 1660번 문제와 비슷
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kinds = sc.nextInt();
		int howMuch = sc.nextInt();
		int[] coins = new int[kinds + 1];
		for (int i = 1; i <= kinds; i++) {
			coins[i] = sc.nextInt();
		}
		int[] dp = new int[howMuch + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= kinds; i++) {
			for (int j = coins[i]; j <= howMuch; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		if (dp[howMuch] == Integer.MAX_VALUE) {
			dp[howMuch] = -1;
		}
		System.out.println(Integer.MAX_VALUE);
	}
}
