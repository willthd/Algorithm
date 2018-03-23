Solution.javapackage practice;

import java.util.*;

// SWEA, 4012, 요리사
// 백준, 14889, 스타트와 링크. 완전 똑같은 문제
// 10번 테케 시간 초과
// 16^8 -> 16P8 -> 16C8
public class Solution {
	static int m, n, a[], grid[][];
	static boolean checked[];
	static int MIN = (int) 1e9;

	static void func(int dep,int st) {
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
		for (int i = st ; i < n; i++) {
//			안 쓸 수 있다. 생각하자
//			if (checked[i]) {
//				continue;
////			}
			checked[i] = true;
//			a[dep] = i;
			func(dep + 1,i + 1);
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
			MIN = (int)1e9;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					grid[j][k] = sc.nextInt();
				}
			}
			func(0, 0);

			System.out.println("#" + (i + 1) + " " + MIN);
		}
	}
}
