package practice;

import java.util.*;

// 백준, 11066, 파일 합치기
// 이해도 어려웠고, for문 짜는 것도 상당히 헷갈렸다
// dp[i][j] : i부터 j까지 합치는데 필요한 최소 비용
// 최종적으로 하나의 파일이 되도록 합쳐야 한다.
// 합치는 비용은 두 수의 합이다.
// 이 말은, 나 자신을 합치면 비용이 0이고,
// 나와 이웃한 파일끼리 합치면 (i - 1, i나 i, i + 1같은) 나의 파일 + 이웃 파일이다.
// 그럼 파일 3개를 합치면? (A, B, C라고 치자)
// min((A + B) + (A + B + C), (B + C) + (A + B + C))
// 다시 말하면, (A ~ B) 합치는데 드는 비용 + (C ~ C) 합치는데 드는 비용 + A ~ B 파일 합(A + B + C)
// 수식으로 쓰면, dp[i부터][j까지 합치는데 드는 비용] = dp[i][k] + dp[k+1][j] + sum[i부터 j까지의 합]
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int arr[] = new int[n + 1];
			long sum[] = new long[n + 1];
			long dp[][] = new long[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
				sum[i] = sum[i - 1] + arr[i];
			}
			
			// n이 4라면 아래 순서로 채워져야 한다
			// dp[1][2], dp[1][3], dp[3][4]
			// dp[1][3], dp[2][3]
			// dp[1][4]
			for (int k = 1; k < n; k++) {
				for (int i = 1; i <= n - k; i++) {
					dp[i][i + k] = (long) 1e9;
					for (int j = i; j < i + k; j++) {
						dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k]);
					}
					dp[i][i + k] += sum[i + k] - sum[i - 1];
				}
			}
			System.out.println(dp[1][n]);
		}
	}
}