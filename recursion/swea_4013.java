package practice;

import java.util.*;

// SWEA, 4013, 특이한 자석
// 백준, 14891, 톱니바퀴와 똑같다
// 언제 초기화 할 것이냐 중요
public class Main2 {
	static int gear[][], dir[];
	static boolean checked[];

	static void check(int num, int direction) {
		if (checked[num]) {
			return;
		}
		checked[num] = true;
		dir[num] = direction;
		if (num + 1 <= 3) {
			if (gear[num][2] != gear[num + 1][6]) {
				check(num + 1, (-1) * direction);
			}
		}
		if (num - 1 >= 0) {
			if (gear[num][6] != gear[num - 1][2]) {
				check(num - 1, (-1) * direction);
			}
		}
		return;
 	}

	static void spin() {
		for (int i = 0; i < 4; i++) {
			if (dir[i] == 1) {
				int temp = gear[i][7];
				for (int j = 0; j < 8 - 1; j++) {
					gear[i][7 - j] = gear[i][6 - j];
				}
				gear[i][0] = temp;
			} else if (dir[i] == -1) {
				int temp = gear[i][0];
				for (int j = 0; j < 8 - 1; j++) {
					gear[i][j] = gear[i][j + 1];
				}
				gear[i][7] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			gear = new int[4][8];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 8; k++) {
					gear[j][k] = sc.nextInt();
				}
			}
			dir = new int[4];
			checked = new boolean[4];
			for (int j = 0; j < m; j++) {
				int num = sc.nextInt() - 1;
				int direction = sc.nextInt();
				check(num, direction);
				spin();
				dir = new int[4];
				checked = new boolean[4];
			}
			int result = 0;
			for (int j = 0; j < 4; j++) {
				result += gear[j][0] * Math.pow(2, j);
			}
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}
