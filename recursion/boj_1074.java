package practice;

import java.util.*;

public class Main4 {
	static int n, r, c;
	static boolean flag = false;
	public static void f(int x, int y, int len, int val) {
		if (flag) {
			return;
		}
		if (len == 1) {
			if (x == r && y == c) {
				System.out.println(val);
				flag = true;
				
			}
			return;
		}
		f(x, y, len/2, val);
		f(x, y + len/2, len/2, val + (int)Math.pow(len/2, 2) * 1);
		f(x + len/2, y, len/2, val + (int)Math.pow(len/2, 2) * 2);
		f(x + len/2, y + len/2, len/2, val + (int)Math.pow(len/2, 2) * 3);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n = (int)Math.pow(2, n);
		r = sc.nextInt();
		c = sc.nextInt();
		f(0, 0, n, 0);
	}
	
}