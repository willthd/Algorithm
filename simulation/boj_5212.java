package practice;

import java.util.*;

public class Main4 {
	static int r, c;
	static String g[][];
	static boolean ch[][];
	
	public static boolean check(int a, int b) {
		int cnt = 0;
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};
		for (int i = 0; i < 4; i++) {
			if (a + dx[i] < 0 || a + dx[i] >= r + 2 || b + dy[i] < 0 || b + dy[i] >= c + 2) {
				continue;
			}
			if (g[a + dx[i]][b + dy[i]].equals(".")) {
				cnt++;
			}
		}
		if (cnt >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		g = new String[r + 2][c + 2];
		ch = new boolean[r + 2][c + 2];
		for (int i = 0; i < r + 2; i++) {
			g[i][0] = ".";
			g[i][c + 1] = ".";
		}
		for (int i = 0; i < c + 2; i++) {
			g[0][i] = ".";
			g[r + 1][i] = ".";
		}
		for (int i = 1; i < r + 1; i++) {
			String s = sc.next();
			for (int j = 1; j < c + 1; j++) {
				g[i][j] = s.charAt(j - 1) + "";
			}
		}
		
		for (int i = 0; i < r + 2; i++) {
			for (int j = 0; j < c + 2; j++) {
				if (check(i, j)) {
					ch[i][j] = true;
				}
			}
		}
		for (int i = 0; i < r + 2; i++) {
			for (int j = 0; j < c + 2; j++) {
				if (ch[i][j]) {
					g[i][j] = ".";
				}
				System.out.print(g[i][j]);
			}
			System.out.println();
		}
	}
}