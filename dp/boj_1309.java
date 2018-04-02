package practice;

import java.util.*;

// 백준, 1309, 동물원
// dp[i][j] : i번째 j칸을 쓸 때, 사자를 배치할 수 있는 경우의 수. j가 0이면 왼쪽, 오른쪽 둘 다 사용하지 않는 것
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[n + 1][3];
		for (int i = 0; i < 3; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % 9901;
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % 9901;
		}
		long result = 0;
		for (int i = 0; i < 3; i++) {
			result += dp[n][i] % 9901;
		}
		System.out.println(result % 9901);
	}
}