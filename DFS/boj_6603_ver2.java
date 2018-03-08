package practice;

import java.util.Scanner;

// 백준, 6603, 로또, ver2
// ver1과 비교해봐라 DFS back tracking 부분
// DFS + back tracking. 결국엔 DFS 메소드로 전부 해결나는 문제. 근데 이거 왜이렇게 생각이 안떠오르는거지...
// 일단 DFS 함수는 매개변수로 index는 꼭 들고 있어야한다. cnt는 들고 있는 경우와 그렇지 않은 경우 있음. 어떤게 더 좋은 방법일까?
public class Main {
	static int n;
	static int[] a;
	static int cnt;

	static void dfs(int index, String ans) {
		if (cnt == 6) {
			System.out.println(ans);
		}
		for (int i = index; i < n; i++) {
			cnt++;
			dfs(i + 1, ans + a[i] + " ");
		}
		cnt--;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			cnt = 0;
			dfs(0, "");
			System.out.println();
		}
	}
}
