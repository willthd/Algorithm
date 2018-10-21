package practice;

import java.util.*;

public class Main4 {
	static int n, pay[], day[], max = Integer.MIN_VALUE;
	static boolean v[];

	public static void f(int curr_sum, int curr_day) {
		if (curr_day == n + 1) {
			max = Math.max(max, curr_sum);
			return;
		}
		int next_day = curr_day + day[curr_day];
		int next_sum = curr_sum + pay[curr_day];
		// 오늘을 포함 시킨 경우
		if (next_day <= n + 1) {
			f(next_sum, next_day);
		}
		// 오늘을 포함 시키지 않은 경우
		if (curr_day + 1 <= n + 1) {
			f(curr_sum, curr_day + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		day = new int[n + 1];
		pay = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		f(0, 1);
		System.out.println(max);
	}
}
