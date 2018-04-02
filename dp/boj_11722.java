package practice;

import java.util.*;

// 백준, 11722, 가장 긴 감소하는 부분 수열
//dp[i] : i번째 수를 사용하는 감소하는 부분 수열의 최대 길이
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			long max = 0;
			for (int j = 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}