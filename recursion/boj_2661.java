import java.util.*;

// 백준, 2661, 좋은 수열
public class Main2 {
	static int n, a[];
	static boolean flag = false;
	
	static boolean check(int dep) {
		for (int i = 1; i <= dep / 2; i++) {
			String s1 = "";
			String s2 = "";
			for (int j = i - 1; j >= 0; j--) {
				s1 += a[dep - j - 1];
			}
			for (int j = 2 * i - 1; j >= i; j--) {
				s2 += a[dep - j - 1];
			}
			if (s1.equals(s2)) {
				return true;
			}
		}
		return false;
	}
	
	static void func(int dep) {
		if (flag) {
			return;
		}
		if (dep == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			flag = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			a[dep] = i + 1;
			if (check(dep + 1)) {
				continue;
			}
			func(dep + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		func(0);
	}
}