package practice;

import java.util.*;

// long 표기 할 때 숫자 뒤에 l붙인다
public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long arr[][] = new long[n][3];
		long result[] = new long[n];
		long val[] = {1000001000001l, 1000001, 1};
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			for (int j = 0; j < 3; j++) {
				arr[a - 1][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				result[i] += arr[i][j] * val[j];
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);
			if (result[k - 1] < result[i]) {
				cnt++;
			}
		}
		System.out.println(cnt + 1);
	}
}