package practice;

import java.util.*;

// 백준, 2011, 암호코드
// dp[i] : 문자열의 i번째 숫자를 사용하는 암호 코드
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		int dp[] = new int[len + 1];
		int arr[] = new int[len + 1];
		for (int i = 0; i < len; i++) {
			arr[i + 1] = s.charAt(i) - '0';
		}
		dp[0] = 1;
		for (int i = 1; i <= len; i++) {
			if (arr[i] != 0) {
				dp[i] = dp[i - 1] % (int) 1e6;
			}
			int x = arr[i] + arr[i - 1] * 10;
			if (10 <= x && x <= 26) {
				dp[i] = (dp[i - 2] + dp[i]) % (int) 1e6;
			}
		}
		System.out.println(dp[len] % (int) 1e6);
	}
}