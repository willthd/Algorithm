package practice;

import java.util.*;

// 백준, 11055, 가장 큰 증가 부분 수열
// 백준, 11053 문제와 비슷
//dp[i] : i 번째 원소를 포함하는 증가하는 부분 수열의 원소 합 중 최대값
//dp[i] : 1 ~ i - 1까지의 원소들에서, i번째 원소보다 값이 작은것들 중, 가장 큰 dp값 + arr[i]
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		for (int i = 1; i <= n; i++) {
			long max = 0;
			for (int j = 1; j < n; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + arr[i];
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
