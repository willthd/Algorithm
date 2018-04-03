
package practice;

import java.util.*;

// 백준, 11054, 가장 긴 바이토닉 부분 수열
// dp1[n] : n번째 원소를 포함하는 가장 긴 부분 수열의 길이
// dp2[n] : n번째 원소를 포함하는 가장 긴 부분 수열의 길이(dp1[]의 역순)
// dp[n] : n번째 원소를 증감의 기점으로 하는 바이토닉 수열의 길이 
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n + 1];
		long dp1[] = new long[n + 1];
		long dp2[] = new long[n + 2];
		long dp[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			long max1 = 0;
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i]) {
					max1 = Math.max(max1, dp1[j]);
				}
			}
			dp1[i] = max1 + 1;
		}
		for (int i = n; i >= 1; i--) {
			long max2 = 0;
			for (int j = n; j > i; j--) {
				if (arr[j] < arr[i]) {
					max2 = Math.max(max2,  dp2[j]);
				}
			}
			dp2[i] = max2 + 1; 
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dp1[i] + dp2[i] - 1);
		}
		System.out.println(result);
	}
}