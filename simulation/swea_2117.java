package practice;

import java.util.*;

// SWEA, 2117, 홈 방범 서비스
public class pp {
	static int n, m, g[][], cnt, max = (int) -1e9;
	
	static boolean isRange(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		}
		return false;
	}
	
	static void check(int x, int y, int k) {
		int upx = 0;
		int downx = 0;;
		int upy = 0;
		int downy = 0;
		cnt = 0;
		for (int i = 1; i < k - 1; i++) {
			upx = x - i;
			downx = x + i;
			for (int j = k - 1 - i; j > 0; j--) {
				upy = y + j;
				downy = y - j;
				if (isRange(upx, upy) && g[upx][upy] == 1) {
					cnt++;
				}
				if (isRange(upx, downy) && g[upx][downy] == 1) {
					cnt++;
				}
				if (isRange(downx, upy) && g[downx][upy] == 1) {
					cnt++;
				}
				if (isRange(downx, downy) && g[downx][downy] == 1) {
					cnt++;
				}
			}
		}
		for (int i = - k + 1; i < k; i++) {
			if (i == 0) {
				continue;
			}
			if (isRange(x + i, y) && g[x + i][y] == 1) {
				cnt++;
			}
			if (isRange(x, y + i) && g[x][y + i] == 1) {
				cnt++;
			}
		}
		if (isRange(x, y) && g[x][y] == 1) {
			cnt++;
		}
		if ((k * k) + (k - 1) * (k - 1) <= cnt * m ) {
			max = Math.max(max, cnt);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			max = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			g = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 1; k <= n + 1; k++) {
						check(i, j, k);
					}
				}
			}
			System.out.println("#" + (tt + 1) + " " + max);
		}
	}
}

