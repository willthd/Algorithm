package practice;

import java.util.*;

public class Main7 {
	static int arr_st[], arr_ba[], n, cnt = 0;
	static String a[], num[];
	static boolean check[];
	
	public static void f(int dep) {
		if (dep == 3) {
			if (check(a)) {
				cnt++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			a[dep] = i + 1 + "";
			f(dep + 1);
			check[i] = false;
		}
	}
	
	public static boolean check(String a[]) {
		for (int i = 0; i < n; i++) {
			int st = 0;
			int ba = 0;
			String cp = num[i];
			for (int j = 0; j < 3; j++) {
				if (a[j].equals(cp.charAt(j) +"")) {
					st++;
					ba--;
				}
				if (cp.contains(a[j])) {
					ba++;
				}
			}
			if (st != arr_st[i] || ba != arr_ba[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new String[n];
		arr_st = new int[n];
		arr_ba = new int[n];
		check = new boolean[9];
		a = new String[3];
		for (int i = 0; i < n; i++) {
			num[i] = sc.next();
			arr_st[i] = sc.nextInt();
			arr_ba[i] = sc.nextInt();
		}
		f(0);
		System.out.println(cnt);
	}
}