package practice;

import java.util.*;

// AlgoLabs, 테트리미노
// 영역 빠져나가는 부분만큼 영역 크게 할당하기
public class Solution {
	static int n, m, g[][], cnt, max, xx;
	
	static void makeOne(int x, int y) {
		for (int i = 0; i < 4; i++) {
			g[x - i][y] = 1;
		}
	}
	
	static void makeZero(int x, int y) {
		for (int i = 0; i < 4; i++) {
			g[x - i][y] = 0;
		}
	}
	
	static boolean canCount(int x, int y) {
		for (int i = 0; i < m; i++) {
			if (g[x][i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean check(int x, int y) {
		if (g[x][y] == 0 && g[x - 1][y] == 0 && g[x - 2][y] == 0 && g[x - 3][y] == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n + 3][m];
		for (int i = 0; i < n + 3; i++) {
			Arrays.fill(g[i], 1);
		}
		for (int i = 3; i < n + 3; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		for (int i = 3; i < n + 3; i++) {
			for (int j = 0; j < m; j++) {
				if (check(i, j)) {
					cnt = 0;
					makeOne(i, j);
					for (int k = 0; k < 4; k++) {
						if (canCount(i - k, j)) {
							cnt++;
						}
					}
					if (max < cnt) {
						max = cnt;
						xx = j;
					}
					makeZero(i, j);
				}
			}
		}
		if (cnt == 0) {
			System.out.println(0 + " " + 0);
		} else {
			System.out.println((xx + 1) + " " + max);
		}
	}
}