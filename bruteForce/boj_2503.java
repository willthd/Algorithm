package practice;

import java.util.*;

// 백준, 2503, 숫자 야구
public class Solution {
	static int n, a[], cnt1, cnt2;
	static boolean checked[];
	static String arr[];
	static int cnt = 0;

	static void func(int dep) {
		if (dep == 3) {
			String s = "";
			for (int i = 0; i < 3; i++) {
				s += a[i] + "";
			}
			for (int i = 0; i < n; i++) {
				String temp[] = arr[i].split(" ");
				check(s, temp);
				if (cnt1 != Integer.parseInt(temp[1]) || cnt2 != Integer.parseInt(temp[2])) {
					break;
				}
				if (i == n - 1) {
					cnt++;
				}
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (checked[i] == true) {
				continue;
			}
			checked[i] = true;
			a[dep] = i;
			func(dep + 1);
			checked[i] = false;
		}
	}

	static void check(String s, String temp[]) {
		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < 3; i++) {
			if (s.charAt(i) == temp[0].charAt(i)) {
				cnt1++;
			} else {
				if (s.contains(temp[0].charAt(i) + "")) {
					cnt2++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		a = new int[9999999];
		checked = new boolean[9999999];
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		func(0);
		System.out.println(cnt);
	}
}