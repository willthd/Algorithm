package practice;

import java.util.*;

public class Main7 {
	static int r, a[];
	static boolean flag;
	
	public static void f(int dep) {
		if (flag) {
			return;
		}
		if (dep == r) {
			flag = true;
			for (int i = 0; i < r; i++) {
				System.out.print(a[i]);
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			a[dep] = i + 1;
			if (!check(dep)) {
				continue;
			}
			f(dep + 1);
		}
	}
	
	public static boolean check(int dep) {
		for (int i = 1; i <= dep / 2 + 1; i++) {
			for (int j = 0; j <= dep - i * 2 + 1; j++) {
				int cnt = 0;
				for (int k = 0; k < i; k++) {
					if (a[j + k] == a[j + i + k]) {
						cnt++;
					}
				}
				if (cnt == i) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		a = new int[r];
		f(0);
	}
}