package practice;

import java.util.*;

// SWEA, 4014, 활주로 건설
// 백준, 14890, 경사로 문제와 똑같다
public class Main {
	static int n, x, grid1[][], grid2[][], cnt;

	static boolean checkAll(int arr[]) {
		boolean checked[] = new boolean[n];
		if (check(arr, checked) && checkReverse(arr, checked)) {
			return true;
		}
		return false;
	}

	static boolean check(int arr[], boolean checked[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				if (arr[i + 1] - arr[i] == 1) {
					if (i - (x - 1) >= 0) {
						for (int j = i - (x - 1); j <= i; j++) {
							if (!checked[j]) {
								checked[j] = true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkReverse(int arr[], boolean checked[]) {
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				if (arr[i - 1] - arr[i] == 1) {
					if (i + (x - 1) <= arr.length - 1) {
						for (int j = i + (x - 1); j >= i; j--) {
							if (!checked[j]) {
								checked[j] = true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			n = sc.nextInt();
			x = sc.nextInt();
			grid1 = new int[n][n];
			grid2 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					grid1[i][j] = sc.nextInt();
					grid2[j][i] = grid1[i][j];
				}
			}

			cnt = 0;
			for (int i = 0; i < n; i++) {
				if (checkAll(grid1[i])) {
					cnt++;
				}
				if (checkAll(grid2[i])) {
					cnt++;
				}
			}
			System.out.println("#" + (tt + 1) + " " + cnt);
		}
	}
}
