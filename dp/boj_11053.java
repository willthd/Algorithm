package practice;

import java.util.*;

// 백준, 11053, 가장 긴 증가하는 부분 수열
//dp[i] : i 번째 원소를 포함하는 LIS의 길이, 최종 정답은 dp[n]이 아니다
//dp[i] : 1 ~ i - 1까지의 원소들에서, i번째 원소보다 값이 작은것들 중, 가장 큰 dp값 + 1
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = 1;
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
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
