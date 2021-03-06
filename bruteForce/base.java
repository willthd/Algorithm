package practice;

import java.util.*;

//n = 5(한 node에서 뻗치는 브랜치 수), r = 3(depth)
public class pp {
	static int n, r, a[], count[], num[];
	static boolean check[];

	// nPr, 순열 (1~5 중에서 3개 뽑아서 중복 x, 순서 o)
	public static void f2(int dep) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			a[dep] = i + 1;
			f2(dep + 1);
			check[i] = false;
		}
	}

	// n^r(n파이r), 중복 순열(1~5 중에서 3개 뽑아서 중복 o, 순서 o)
	public static void f1(int dep) {
		// depth를 어디까지 진행할 것인가
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		// 아래 for문 만으로 n^r번 돈다
		// 가지를 몇 개로 뻗을 것인가
		for (int i = 0; i < n; i++) {
			a[dep] = i + 1;
			// 새로운 노드에서 가지를 만든다. 그렇기 때문에 가지 수만큼 for문을 돌아야한다
			f1(dep + 1);
		}
	}

	// 변형된 중복순열 (일부 중복 o, 순서 o)
	// 기본적으로 순열은 서로 다른 수들을 순서 있게 나열 하는 것이지만, n개의 수 중에서 일부가 겹치는 경우 있다
	// 이 때 수를 나열하는 방법. 즉 일부 중복 가능, 순서 있는 나열. 여기선 총 숫자의 개수가 n개이고, 종류는 4개, cnt[]는 4가지
	// 종류가 n개중 몇 개씩 있는지
	// ex) 1,1,2,2,3,5,5,5, 7 중 5개 뽑아서 순열
	public static void f3(int dep) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (count[i] == 0) {
				continue;
			}
			count[i]--;
			a[dep] = num[i];
			f3(dep + 1);
			count[i]++;
		}
	}

	// nCr, 조합 (1~5 중에서 3개 뽑아서 중복 x, 순서 x)
	public static void f4(int dep, int st) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = i + 1;
			f4(dep + 1, i + 1);
		}
	}

	// nHr(n+r-1Cr), 중복 조합 (1~5 중에서 3개 뽑아서 중복 o, 순서 x)
	public static void f5(int dep, int st) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = st; i < n; i++) {
			a[dep] = i + 1;
			f5(dep + 1, i);
		}
	}


	// 변형된 중복조합 (일부 중복 o, 순서 x)
	// 기본적으로 조합은 서로 다른 수들을 순서 없게 나열 하는 것이지만, n개의 수 중에서 일부가 겹치는 경우 있다
	// 이 때 수를 나열하는 방법. 즉 일부 중복 가능, 순서 없는 나열. 여기선 총 숫자의 개수가 n개이고, 종류는 4개, cnt[]는 4가지
	// 종류가 n개중 몇 개씩 있는지
	// ex) 1,1,2,2,3,5,5,5, 7 중 5개 뽑아서 순열
	public static void f6(int dep, int st) {
		if (dep == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = st; i < n; i++) {
			if (count[i] == 0) {
				continue;
			}
			count[i]--;
			a[dep] = i;
			f(dep + 1, i);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		a = new int[r];
		check = new boolean[n];
		count = new int[n];
		// 어떤 종류의 숫자를 넣을 것인지. 여기서 그 종류는 5개
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		// 각 숫자가 몇 개씩 존재하는지
		for (int i = 0; i < n; i++) {
		count[i] = sc.nextInt();
		}
		// f1(0);
		// f2(0);
		// f3(0);
		// f4(0, 0);
		f5(0, 0);
	}
}
