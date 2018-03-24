package practice;

import java.util.*;

// CodeUp, 3530, 스도쿠
public class Main5 {
	static int a[][];
	static int check1[][], check2[][], check3[][];
	static int x[], y[], zeroNum;

	static int func(int w) {
		if (w == zeroNum) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			return 1;
		}
		for (int i = 1; i <= 9; i++) {
			int xx = x[w], yy = y[w];
			if (check1[xx][i] == 1 || check2[yy][i] == 1 || check3[xx / 3 * 3 + yy / 3][i] == 1) {
				continue;
			}
			check1[xx][i] = check2[yy][i] = check3[xx / 3 * 3 + yy / 3][i] = 1;
			a[xx][yy] = i;
			if (func(w + 1) == 1) {
				return 1;
			}
			check1[xx][i] = check2[yy][i] = check3[xx / 3 * 3 + yy / 3][i] = 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		a = new int[10][10];
		check1 = new int[10][10];
		check2 = new int[10][10];
		check3 = new int[10][10];
		x = new int[100];
		y = new int[100];
		zeroNum = 0;
		for (i = 0; i < 9; i++)
			for (j = 0; j < 9; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == 0) {
					x[zeroNum] = i;
					y[zeroNum] = j;
					zeroNum++;
				} else {
					check1[i][a[i][j]] = 1;
					check2[j][a[i][j]] = 1;
					check3[i / 3 * 3 + j / 3][a[i][j]] = 1;
				}
			}
		func(0);
	}
}
