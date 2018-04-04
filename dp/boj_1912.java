package practice;

import java.util.*;

// 백준, 1912, 연속합
// dp[i] : arr[i]를 포함할 때의 최대 연속합
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			if (dp[i - 1] + arr[i] > arr[i]) {
				dp[i] = dp[i - 1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
		}
		long max = (int) -1e9;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}