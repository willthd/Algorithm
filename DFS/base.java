package practice;

import java.util.*;

// 재귀. 이런 유형엔 두 가지 경우가 있다. 2^n과 n!
// 둘 다 아래의 코드를 기본 베이스로 하여 변형할 수 있다
// 문제 해결에 따라 if문 내부를 변형하여 답을 구한다
public class Main4 {
	static int n, m, branch[], checked[];

	static void func(int depth) {
		// depth를 어디까지 진행할 것인가
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(branch[i]);
			}
			System.out.println();
			return;
		}
		// 가지를 몇개로 뻗을 것인가
		for (int i = 1; i <= n; i++) {
			// 중요 !!!
			if (checked[i] == 1) {
				continue;
			}
			checked[i] = 1;
			branch[depth] = i;
			func(depth + 1);		// 새로운 노드에서 가지를 만든다. 그렇기 때문에 가지 수만큼 for문을 돌아야한다
			checked[i] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		branch = new int[n + 1];
		checked = new int[n + 1];
		func(0);
	}
}
