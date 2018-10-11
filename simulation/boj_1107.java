package practice;

import java.util.*;

public class Main5 {
	static int n, a[], target, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE, length;
	static String min_s1 = "-1", min_s2 = "-1", min_s3 = "-1";
	static boolean ch[];
	
	public static void f1(int dep) {
		if (dep == length) {
			String s = "";
			for (int i = 0; i < length; i++) {
				s += a[i];
			}
			if (s.equals("")) {
				return;
			}
			int val = Math.abs(Integer.parseInt(s) - target) + s.length();
			if (min1 > val) {
				min1 = val;
				min_s1 = s;
				int temp = Integer.parseInt(min_s1);
				min_s1 = Integer.toString(temp);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (ch[i]) {
				continue;
			}
			a[dep] = i;
			f1(dep + 1);
		}
	}
	
	public static void f2(int dep) {
		if (dep == length - 1) {
			String s = "";
			for (int i = 0; i < length - 1; i++) {
				s += a[i];
			}
			if (s.equals("")) {
				return;
			}
			int val = Math.abs(Integer.parseInt(s) - target) + s.length();
			if (min2 > val) {
				min2 = val;
				min_s2 = s;
				int temp = Integer.parseInt(min_s2);
				min_s2 = Integer.toString(temp);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (ch[i]) {
				continue;
			}
			a[dep] = i;
			f2(dep + 1);
		}
	}
	
	public static void f3(int dep) {
		if (dep == length + 1) {
			String s = "";
			for (int i = 0; i < length + 1; i++) {
				s += a[i];
			}
			if (s.equals("")) {
				return;
			}
			int val = Math.abs(Integer.parseInt(s) - target) + s.length();
			if (min3 > val) {
				min3 = val;
				min_s3 = s;
				int temp = Integer.parseInt(min_s3);
				min_s3 = Integer.toString(temp);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (ch[i]) {
				continue;
			}
			a[dep] = i;
			f3(dep + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = sc.nextInt();
		length = Integer.toString(target).length();
		n = sc.nextInt();
		ch = new boolean[10];
		a = new int[length + 1];
		for (int i = 0; i < n; i++) {
			ch[sc.nextInt()] = true;
		}
		int result1 = Math.abs(target - 100);
		f1(0);
		f2(0);
		f3(0);
		int temp1;
		int temp2;
		int temp3;
		if (!min_s1.equals("-1")) {
			temp1 = Math.abs(Integer.parseInt(min_s1) - target) + min_s1.length();			
		} else {
			temp1 = Integer.MAX_VALUE;
		}
		if (!min_s2.equals("-1")) {
			temp2 = Math.abs(Integer.parseInt(min_s2) - target) + min_s2.length();
		} else {
			temp2 = Integer.MAX_VALUE;			
		}
		if (!min_s3.equals("-1")) {
			temp3 = Math.abs(Integer.parseInt(min_s3) - target) + min_s3.length();
		} else {
			temp3 = Integer.MAX_VALUE;			
		}
		int result2 = Math.min(Math.min(temp1, temp2), temp3);
		System.out.println(Math.min(result1, result2));
	}
}