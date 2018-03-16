package practice;

import java.util.Scanner;

// codeUp, 2626, 삼각화단(large)
// n이 커지면 통과 못하는 경우 있다
// 따라서 3중 for문 2중 for문으로 변경해서 풀기
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				if (n - i - j >= 1) {
					if ((n - i - j) % 1 == 0) {
						if (2 * i < n ) {
							if ((n - i - j) <= j) {
								cnt++;								
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
