package practice;

import java.util.*;

// 백준, 1965, 상자 넣기
// 백준, 11053이랑 동일한 문제
//dp[i] : i번째 원소에 1~i-1까지 상자를 넣은 최대 개수
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