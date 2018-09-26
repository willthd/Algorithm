package practice;

import java.util.*;

// 백준, 9663, N-QUEEN
// a[]은 세로 위치
class ppp {
	static int n, a[], cnt = 0;

	public static boolean check(int dep) {
		for (int i = 0; i < dep; i++) {
			if (a[i] == a[dep]) {
				return false;
			}
			if (Math.abs(i - dep) == Math.abs(a[i] - a[dep])) {
				return false;
			}
		}
		return true;
	}

	public static void func(int dep) {
		if (dep == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			a[dep] = i;
			if (!check(dep)) {
				continue;
			}
			func(dep + 1);
		}
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		func(0);
		System.out.println(cnt);
	}
}
