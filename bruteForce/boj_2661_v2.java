package practice;

import java.util.*;

// 백준, 2661, 좋은 수열(ver2)
public class Main3 {
	static int n, a[];

	static int ck(int n) {
		int i, j, k;
		for (i = 1; i * 2 <= n; i++) {
			int flag = 1;
			for (j = 0, k = n - 1; j < i; j++, k--) {
				if (a[k] != a[k - i]) {
					flag = 0;					
				}
			}
			if (flag == 1)
				return 0;
		}
		return 1;
	}

	static int func(int dep) {
		if (dep == n) {
			for (int i = 0; i < n; i++)
				System.out.print(a[i]);
			return 1;
		}
		for (int i = 1; i <= 3; i++) {
			a[dep] = i;
			if (ck(dep + 1) == 0)
				continue;
			if (func(dep + 1) == 1)
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		func(0);
	}
}