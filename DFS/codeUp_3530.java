package practice;

import java.util.*;

// CodeUp, 3530, 스도쿠
public class Main5 {
	static int a[][];
	static boolean check1[][], check2[][], check3[][];
	static int x[], y[], zeroNum;
	
	static void check() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (a[i][j] == 0) {
					System.out.println("Not Possible");
					return;
				}
			}
		}
	}

	static void func(int dep) {
		if (dep == zeroNum) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			int xx = x[dep], yy = y[dep];
			if (check1[xx][i] || check2[yy][i] || check3[xx / 3 * 3 + yy / 3][i]) {
				continue;
			}
			check1[xx][i] = check2[yy][i] = check3[xx / 3 * 3 + yy / 3][i] = true;
			a[xx][yy] = i;
			func(dep + 1);
			check1[xx][i] = check2[yy][i] = check3[xx / 3 * 3 + yy / 3][i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[10][10];
		check1 = new boolean[10][10];
		check2 = new boolean[10][10];
		check3 = new boolean[10][10];
		x = new int[100];
		y = new int[100];
		zeroNum = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == 0) {
					x[zeroNum] = i;
					y[zeroNum] = j;
					zeroNum++;
				} else {
					check1[i][a[i][j]] = true;
					check2[j][a[i][j]] = true;
					check3[i / 3 * 3 + j / 3][a[i][j]] = true;
				}
			}
		}
		func(0);
		check();
	}
}
