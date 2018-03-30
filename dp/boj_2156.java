package practice;

import java.util.*;

// 백준, 2156, 포도주 시식
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		for (int i = 2; i <= n; i++) {
			if (i == 2) {
				dp[i] = arr[1] + arr[2];
				continue;
			}
			if (i == 3) {
				dp[3] = Math.max(dp[2], Math.max(arr[2] + arr[3], arr[1] + arr[3]));
				continue;
			}
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
			
		}
		System.out.println(dp[n]);
	}
}