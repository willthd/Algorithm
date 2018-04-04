package practice;

import java.util.*;

// 백준, 2631, 줄세우기
// 접근 방법 -> 전체 길이 - dp[i]
// dp[i] : i번째 원소를 포함하는 최장 부분 증가 수열
public class pp {
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
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}
		long result = 0;
		for (int i = 0; i <= n; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(n - result);
	}
	
}