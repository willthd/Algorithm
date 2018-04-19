package practice;

import java.util.*;

// SWEA, 1952, 수영장
public class Main4 {
	static int price[], days[], a[], min;

	static void func(int dep, int sum) {
		// dep == 말고 >= 으로 해야한다!!!
		if (dep >= 12) {
			min = Math.min(sum, min);
			return;
		}
		// 이전 코드, 이것만으로 4^12
		for (int i = 0; i < 4; i++) {
			a[dep] = i;
			if (i == 0) {
				func(dep + 1, sum + price[0] * days[dep]);
			} else if (i == 1) {
				func(dep + 1, sum + price[1]);
			} else if (i == 2) {
				func(dep + 3, sum + price[2]);				
			} else if (i == 3) {
				func(dep + 12, sum + price[3]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			days = new int[12];
			a = new int[12];
			min = (int) 1e9;
			for (int i = 0; i < 12; i++) {
				days[i] = sc.nextInt();
			}
			func(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
}
