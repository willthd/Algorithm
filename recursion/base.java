package practice;

import java.util.*;

// Recursion + BackTracking 4가지 경우 유형화
// n = 5(한 node에서 뻗치는 브랜치 수), r = 3(depth)
public class Main7 {
	static int n, a[];
	static boolean checked[];

	// n^r(n파이r), 중복 순열(1~5 중에서 3개 뽑아서 중복 가능, 순서 무시 나열)
	static void f1(int dep) {
		// depth를 어디까지 진행할 것인가
		if (dep == 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		// 가지를 몇 개로 뻗을 것인가
		for (int i = 0; i < n; i++) {
			a[dep] = i + 1;
			f1(dep + 1);
		}
	}

	// nPr, 순열 (1~5 중에서 3개 뽑아서 중복 불가능, 순서 있는 나열)
	static void f2(int dep) {
		if (dep == 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (checked[i]) {
				continue;
			}
			checked[i] = true;
			a[dep] = i + 1;
			f2(dep + 1);
			checked[i] = false;
		}
	}

	// 기본적으로 순열은 서로 다른 수들을 순서 있게 나열 하는 것이지만, n개의 수 중에서 일부가 겹치는 경우 있다
	// 이 때 수를 나열하는 방법. 즉 일부 중복 가능, 순서 있는 나열. 여기선 총 숫자의 개수가 n개이고, 종류는 4개, cnt[]는 4가지 종류가 n개중 몇 개씩 있는지
	static void f2Alpha(int dep) {
		if (dep == n) {
			for (int i = 0; i < 3; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cnt[i] == 0) {
				continue;
			}
			cnt[i]--;
			a[dep] = i + 1;
			f2(dep + 1);
			cnt[i]++;
		}
	}

	// nCr, 조합 (1~5 중에서 3개 뽑아서 중복 불가능, 순서 없는 나열)
	static void f3(int dep, int start) {
		if (dep == 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			a[dep] = i + 1;
			f3(dep + 1, i + 1);
		}
	}

	// nHr(n+r-1Cr), 중복 조합 (1~5 중에서 3개 뽑아서 중복 가능, 순서 없는 나열)
	static void f4(int dep, int start) {
		if (dep == 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			a[dep] = i + 1;
			f4(dep + 1, i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5;
		a = new int[n];
		checked = new boolean[n];
//		f1(0);
//		f2(0);
//		f3(0, 0);
		f4(0, 0);
	}
}
