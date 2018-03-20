package practice;

import java.util.*;

// SWEA, 4012, 요리사
// 스타트와 링크. 완전 똑같은 문제
public class Solution {
	static int m, n, a[], grid[][];
	static boolean checked[];
	static int MIN = 100000000;
	
	static void func(int dep) {
		if (dep == n / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (checked[i] && checked[j]) {
						sum1 += grid[i][j];
					} else if (!checked[i] && !checked[j]) {
						sum2 += grid[i][j];
					}
				}
			}
			MIN = Math.min(MIN, (int) Math.abs(sum1 - sum2));
			return;
		}
		for (int i = 0; i < n; i++) {
//			안 쓸 수 있다. 생각하자
//			if (checked[i]) {
//				continue;
//			}
			checked[i] = true;
//			a[dep] = i;
			func(dep + 1);
			checked[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			n = sc.nextInt();
			a = new int[n];
			checked = new boolean[n];
			grid = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					grid[j][k] = sc.nextInt();
				}
			}
			func(0);
			System.out.println(MIN);			
		}
	}
}