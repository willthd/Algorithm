package practice;

import java.util.*;

// SWEA, 4008, 숫자 만들기
// 백준, 14888, 연산자 문제보다 좀 더 쉽다
// 10번 테케 시간 초과
// Integer.Max 써야되는 경우도 있다
public class Main3 {
	static int n, num[], sum, MAX, MIN;
	static String buho[], a[];
	static boolean checked[];

	static void func(int dep) {
		if (dep == n - 1) {
			String s = "";
			for (int i = 0; i < n - 1; i++) {
				s += num[i] + a[i];
			}
			s += num[n - 1];
			cal(s);
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (checked[i]) {
				continue;
			}
			checked[i] = true;
			a[dep] = buho[i];
			func(dep + 1);
			checked[i] = false;
		}
	}

	static void cal(String s) {
		sum = Integer.parseInt(s.charAt(0) + "");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+') {
				sum += Integer.parseInt((s.charAt(i + 1) + ""));
			}
			if (s.charAt(i) == '-') {
				sum -= Integer.parseInt((s.charAt(i + 1) + ""));
			}
			if (s.charAt(i) == 'x') {
				sum *= Integer.parseInt((s.charAt(i + 1) + ""));
			}
			if (s.charAt(i) == '/') {
				sum /= Integer.parseInt((s.charAt(i + 1) + ""));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			num = new int[n];
			buho = new String[n - 1];
			a = new String[n - 1];
			checked = new boolean[n - 1];
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			Queue<String> q = new LinkedList<>();
			int plus = sc.nextInt();
			for (int j = 0; j < plus; j++) {
				q.add("+");
			}
			int sub = sc.nextInt();
			for (int j = 0; j < sub; j++) {
				q.add("-");
			}
			int multi = sc.nextInt();
			for (int j = 0; j < multi; j++) {
				q.add("x");
			}
			int div = sc.nextInt();
			for (int j = 0; j < div; j++) {
				q.add("/");
			}
			for (int j = 0; j < n - 1; j++) {
				buho[j] = q.poll();
			}
			for (int j = 0; j < n; j++) {
				num[j] = sc.nextInt();
			}
			func(0);
			System.out.println("#" + (i + 1) + " " + (MAX - MIN));
		}
	}
}

// 질문1
// for (int j = 0; j < q.size(); j++) {
// buho[j] = q.poll();
// }
// 질문2
// for (int j = 0; j < sc.nextInt(); j++) {
// q.add("+");
// }