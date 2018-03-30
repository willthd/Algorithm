package practice;

import java.util.*;

// 백준, 11726, 2xn 타일링
// 주의! 피보나치 값이 오버플로우 될 수 있다. 따라서 더한 값의 나눈 값을 저장. 그래도 결과 같다
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1]  + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
