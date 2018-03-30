package practice;

import java.util.*;

// 백준, 9095, 1,2,3 더하기
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[] = new int[t];
		int max = 0;
		for (int i = 0; i < t; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		int dp[] = new int[max + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= max; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		for (int i = 0; i < t; i++) {
			System.out.println(dp[arr[i]]);
		}
	}
}
