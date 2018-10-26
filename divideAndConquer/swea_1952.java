package practice;

import java.util.*;

public class Main4 {
	static int price[], days[], min;

	public static void dfs(int dep, int sum) {
		if (dep >= 12) {
			min = Math.min(sum, min);
			return;
		}
		dfs(dep + 1, sum + price[0] * days[dep]);
		dfs(dep + 1, sum + price[1]);
		dfs(dep + 3, sum + price[2]);
		dfs(dep + 12, sum + price[3]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			min = Integer.MAX_VALUE;
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			days = new int[12];
			for (int i = 0; i < 12; i++) {
				days[i] = sc.nextInt();
			}
			dfs(0, 0);
			System.out.println("#" + (tc + 1) + " " + min);
		}
	}
}
