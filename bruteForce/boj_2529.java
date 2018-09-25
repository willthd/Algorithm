package practice;

import java.util.*;

public class Main7 {
	static int n;
	static boolean check[], flag;
	static String buho[], a[];
	
	public static void f1(int dep) {
		if (flag) {
			return;
		}
		if (dep == n + 1) {
			for (int i = 0; i < n + 1; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			flag = true;
			return;
		}
		// i는 0부터 9까지 넣고, 위에 for문에서 n부터 0까지 출력하는 경우와
        // i는 9부터 0까지 넣고, 위에 for문에서 0부터 n까지 출력하는 경우는 다르다
		for (int i = 0; i < 10; i++) {
			if (check[i]) {
				continue;
			}
			if (dep >= 1) {
				if (!checkNum(dep, i)) {
					continue;
				}
			}
			check[i] = true;
			a[dep] = i + "";
			f1(dep + 1);
			check[i] = false;
		}
	}
	
	public static void f2(int dep) {
		if (flag) {
			return;
		}
		if (dep == n + 1) {
			for (int i = 0; i < n + 1; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			flag = true;
			return;
		}
		// i는 0부터 9까지 넣고, 위에 for문에서 n부터 0까지 출력하는 경우와
        // i는 9부터 0까지 넣고, 위에 for문에서 0부터 n까지 출력하는 경우는 다르다
        // 그냥 큰 값부터 출력할 때는 i는 9부터 넣고, 작은 값 출력할 때는 0부터 넣어서 위에서 순서대로 출력한다
		for (int i = 9; i >= 0; i--) {
			if (check[i]) {
				continue;
			}
			if (dep >= 1) {
				if (!checkNum(dep, i)) {
					continue;
				}
			}
			check[i] = true;
			a[dep] = i + "";
			f2(dep + 1);
			check[i] = false;
		}
	}
	
	public static boolean checkNum(int dep, int i) {
		int temp = Integer.parseInt(a[dep - 1]);
		if (buho[dep - 1].equals("<")) {
			// 주의! i : a[dep]을 의미한다
			if (temp > i) {
				return false;
			}
		} else {
			if (temp < i) {
				return false;
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
		f2(0);
		flag = false;
		f1(0);
	}
}