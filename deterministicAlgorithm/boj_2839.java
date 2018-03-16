package practice;
import java.util.Scanner;

// 백준, 2839, 설탕 배달
// for문 돌 때, n / 3 까지만 돈다
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 999999999;
		for (int i = 0; i <= n / 3; i++) {
			if ((n - 3 * i) % 5 != 0) {
				continue;
			}
			int j = (n - 3 * i) / 5;
			if (min > i + j) {
				min = i + j;
			}
		}
		if (min == 999999999) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}