package practice;

import java.util.Scanner;

// 이친수
public class Solution {
	public static long boj2193(int input) {
		long[] results = new long[input + 1];
		results[0] = 0;
		results[1] = 1;
		for (int i = 2; i <= input; i++) {
			results[i] = results[i - 1] + results[i - 2];
		}
		return results[input];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int input = Integer.parseInt(temp);
		System.out.println(boj2193(input));
	}
}
