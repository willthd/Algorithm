package practice;

import java.util.*;

public class Main7 {
	static int n;
	static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
	static boolean check[];
	static String buho[], a[], max_st = "", min_st = "";
	
	public static void f(int dep) {
		if (dep == n + 1) {
			if (checkNum()) {
				String temp = "";
				for (int i = 0; i < n + 1; i++) {
					temp += a[i];
				}
				long tempNum = Long.parseLong(temp);
				if (max < tempNum) {
					max = tempNum;
					max_st = temp;
				}
				if (min > tempNum) {
					min = tempNum;
					min_st = temp;
				}
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			a[dep] = i + "";
			f(dep + 1);
			check[i] = false;
		}
	}
	
	public static boolean checkNum() {
		for (int i = 0; i < buho.length; i++) {
			int l = Integer.parseInt(a[i]);
			int r = Integer.parseInt(a[i + 1]);
			if (buho[i].equals("<")) {
				if (l > r) {
					return false;
				}
			} else {
				if (l < r) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		buho = new String[n];
		a = new String[n + 1];
		check = new boolean[10];
		for (int i = 0; i < n; i++) {
			buho[i] = sc.next();
		}
		f(0);
		System.out.println(max_st);
		System.out.println(min_st);
	}
}