package practice;

import java.util.*;

public class Main7 {
	static int n = 1, arr[], a[];
	
	public static void f(int dep, int st) {
		if (n == 0) {
			return;
		}
		if (dep == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = arr[i];
			f(dep + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(n != 0) {
			n = sc.nextInt();
			arr = new int[n];
			a = new int[6];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			f(0, 0);
			System.out.println();
		}
		
	}
}