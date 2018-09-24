package practice;

import java.util.*;

public class Main7 {
	static int a[], num[];
	
	public static void f(int dep, int st) {
		if (dep == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += a[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(a[i]); 
				}
			}
			return;
		}
		for (int i = st; i < 9; i++) {
			a[dep] = num[i];
			f(dep + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[7];
		num = new int[9];
		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		f(0, 0);
	}
}