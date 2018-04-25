package practice;
import java.util.*;

// 임의의 자연수 n에 대해 아래와 같이 나타낼 수 있는 수와 총 개수를 출력해라
//      4 = 3+1
//		  = 2+2
//		  = 2+1+1
// 		  = 1+1+1+1
// 출력 : 31
//       22
//       211
//       1111
//       4
public class pp {
	static int n, a[], cnt;

	static void func(int dep, int sum) {
		if (sum == n) {
			cnt++;
			for (int i = 0; i < dep; i++) {
				if (i == dep - 1) {
					System.out.print(a[i]);
				} else {
					System.out.print(a[i] + "+");
				}
			}
			System.out.println();
			return;
		}
		if (sum > n) {
			return;
		}
		for (int i = n - 1; i > 0; i--) {
			if (dep - 1 >= 0) {
				// 주의! i : a[dep]을 의미한다
				if (i > a[dep - 1]) {
					continue;
				}
			}
			a[dep] = i;
			func(dep + 1, sum + i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		func(0, 0);
		System.out.println(cnt);
	}
}
