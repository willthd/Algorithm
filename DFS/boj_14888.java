package practice;

import java.util.*;

// 백준, 14888, 연산자 끼워넣기
// 어렵다...뭔가 이전의 풀었던 전형적인 DFS문제와는 다른 느낌이었다. 새로운 문제를 봤을 때,
// 어떤 알고리즘으로 풀 것인가를 고민해봐야 할 것 같다
public class Solution {
	static int n, p, s, m, d;
	static int plus, sub, multi, div;
	static int[] numbers;
	static List<Integer> values = new ArrayList<>();
	
	static void dfs(int index, int p, int s, int m, int d, int result) {
		if (index == n) {
			values.add(result);
			return;
		}
		if (p < plus) {
			dfs(index + 1, p + 1, s, m, d, result + numbers[index]);
		}
		if (s < sub) {
			dfs(index + 1, p, s + 1, m, d, result - numbers[index]);
		}
		if (m < multi) {
			dfs(index + 1, p, s, m + 1, d, result * numbers[index]);
		}
		if (d < div) {
			dfs(index + 1, p, s, m, d + 1, result / numbers[index]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		plus = sc.nextInt();
		sub = sc.nextInt();
		multi = sc.nextInt();
		div = sc.nextInt();
		dfs(1, 0, 0, 0, 0, numbers[0]);
		System.out.println(Collections.max(values));
		System.out.println(Collections.min(values));
	}
}
