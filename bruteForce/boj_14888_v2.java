package practice;

import java.util.*;

public class Main7 {
	static int n, r, a[], arr[], count[], max = -(int)1e9, min = (int)1e9;
	
	public static void f(int dep) {
		if (dep == n - 1) {
			int result = arr[0];
			for (int i = 0; i < n - 1; i++) {
				if (a[i] == 0) {
					result += arr[i + 1];
				}
				if (a[i] == 1) {
					result -= arr[i + 1];
				}
				if (a[i] == 2) {
					result *= arr[i + 1];
				}
				if (a[i] == 3) {
					result /=  arr[i + 1];
				}
			}
			if (max < result) {
				max = result;
			}
			if (min > result) {
				min = result;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (count[i] == 0) {
				continue;
			}
			count[i]--;
			a[dep] = i;
			f(dep + 1);
			count[i]++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n - 1];
		arr = new int[n];
		count = new int[4];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			count[i] = sc.nextInt();
		}
		f(0);
		System.out.println(max);
		System.out.println(min);
	}
}