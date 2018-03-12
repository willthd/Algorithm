package practice;

import java.util.Scanner;

// 백준, 9084, 동전
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] answers = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			int coinsNum = sc.nextInt();
			int[] coins = new int[coinsNum + 1];
			for (int j = 1; j <= coinsNum; j++) {
				coins[j] = sc.nextInt();
			}
			int howMuch = sc.nextInt();
			int[] dp = new int[howMuch + 1];
			// 첫째항 굉장히 중요하다. 여기선 1이다
			dp[0] = 1;
			for (int j = 1; j <= coinsNum; j++) {
				// k는 coins[j] 이전은 확인할 필요 없다. 어차피 카운팅이 안되기 때문
				//첫번째 dp[]는 첫번째 동전으로 계산 가능한 횟수로 채워지고, 두번째 dp[]는
				// 첫번째 dp[]에 두번째 동전으로 계산 가능한 횟수를 합한 것으로 채워진다. 이렇게 계속 반복된다
				for (int k = coins[j]; k <= howMuch; k++) {
					dp[k] += dp[k - coins[j]];
				}
			}
			answers[i] = dp[howMuch];
		}
		for (int i = 0; i < answers.length; i++) {
			System.out.println(answers[i]);
		}
	}
}
