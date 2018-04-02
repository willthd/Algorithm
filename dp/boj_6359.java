
package practice;

import java.util.*;

// 백준, 6359, 만취한 상범
// dp[i] : i번째 문의 상태. -1이면 닫힘. 1이면 열림. dp문제에 있어서 배열 이름은 dp로 했지만 dp로 풀 이유 없음
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = sc.nextInt();
			int dp[] = new int[n + 1];
			Arrays.fill(dp, -1);
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (j % i == 0) {
						dp[j] *= (-1);
					}
				}
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (dp[i] == 1) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}