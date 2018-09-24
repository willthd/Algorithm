package practice;

import java.util.*;

public class Main7 {
	static int n, r;
	static String a[], str[];

	public static void f(int dep, int st) {
		if (dep == r) {
			String temp = "";
			for (int i = 0; i < r; i++) {
				temp += a[i];
			}
			if (check(temp)) {
				System.out.println(temp);
			}
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = str[i];
			f(dep + 1, i + 1);
		}
	}

	public static boolean check(String temp) {
		int mo = 0;
		int ja = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == 'a') {
				mo++;
			} else if (temp.charAt(i) == 'e') {
				mo++;
			} else if (temp.charAt(i) == 'i') {
				mo++;
			} else if (temp.charAt(i) == 'o') {
				mo++;
			} else if (temp.charAt(i) == 'u') {
				mo++;
			} else {
				ja++;
			}
		}
		if (mo >= 1 && ja >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		n = sc.nextInt();
		a = new String[r];
		str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		Arrays.sort(str);
		f(0, 0);
	}
}