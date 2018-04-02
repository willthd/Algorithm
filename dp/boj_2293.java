package practice;

import java.util.*;

// 백준, 2293, 동전1 
// 전체 문제 : n개로 k원 만들 수 있는 경우의 수 : dp[n][k]
// 대개 n과 n-1과의 관계를 설정했는데, 변수를 무엇으로 해야할지 감이 안왔다. 변수 두 개인 경우가 이렇다
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp[][] = new int[n + 1][k + 1];
		int coins[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coins[i] = sc.nextInt();
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j - coins[i] < 0) {
					// 마지막 코인이 목표 가치보다 크면 그 코인을 사용하지 않을 때랑 같기 때문
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
