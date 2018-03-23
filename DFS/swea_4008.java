package practice;

import java.util.*;

// SWEA, 4008, 숫자 만들기
// 백준, 14888, 연산자 문제보다 좀 더 쉽다
// 10번 테케 시간 초과
// Integer.Max 써야되는 경우도 있다
// 언제 초기화 할 것이냐 중요
// a배열 스트링 쓸 필요 있느냐. 스트링은 더하기 연산 오래 걸린다 
public class Main3 {

	static int cnt[], num[], a[];
	static int MAX, MIN, n;

	static void f(int dep) {
		if (dep == n - 1) {
			int sum = num[0];
			for (int i = 0; i < n - 1; i++) {
				if (a[i] == 0) {
					sum += num[i + 1];
				}
				if (a[i] == 1) {
					sum -= num[i + 1];
				}
				if (a[i] == 2) {
					sum *= num[i + 1];
				}
				if (a[i] == 3) {
					sum /= num[i + 1];
				}
			}
			if (MIN > sum)
				MIN = sum;
			if (MAX < sum)
				MAX = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cnt[i] == 0) {
				continue;
			}
			cnt[i]--;
			a[dep] = i;
			f(dep + 1);
			cnt[i]++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			n = sc.nextInt();
			cnt = new int[4];
			num = new int[n];
			a = new int[n - 1];
			for (int i = 0; i < 4; i++) {
				cnt[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			MAX = -(int) 1e9;
			MIN = (int) 1e9;
			f(0);
			System.out.println("#" + (tc + 1) + " " + Math.abs(MAX - MIN));
		}
	}
}
