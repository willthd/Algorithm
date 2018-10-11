package practice;

import java.util.*;

public class Main5 {
	static int n, r, c, result;

	public static void f(int x, int y, int length) {
		if (length == 2) {
			if (x == r && y == c) {
				System.out.print(result);
				return;
			}
			result++;
			if (x == r && y + 1 == c) {
				System.out.print(result);
				return;
			}
			result++;
			if (x + 1 == r && y == c) {
				System.out.print(result);
				return;
			}
			result++;
			if (x + 1 == r && y + 1 == c) {
				System.out.print(result);
				return;
			}
			result++;
			return;
		}
		f(x, y, length / 2);
		f(x, y + length / 2, length / 2);
		f(x + length / 2, y, length / 2);
		f(x + length / 2, y + length / 2, length / 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		f(0, 0, (int) Math.pow(2, n));
	}
}