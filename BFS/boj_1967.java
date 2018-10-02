package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int g[][] = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			g[a - 1][b - 1] = c;
			g[b - 1][a - 1] = c;
		}
		int max = Integer.MIN_VALUE;
		int index = -1;

		int st = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean v[] = new boolean[n];
		int d[] = new int[n];
		q.add(st);
		v[st] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < n; i++) {
				if (v[i]) {
					continue;
				}
				if (g[now][i] == 0) {
					continue;
				}
				q.add(i);
				v[i] = true;
				d[i] = d[now] + g[now][i];
				if (max < d[i]) {
					max = d[i];
					index = i;
				}
			}
		}

		v = new boolean[n];
		d = new int[n];
		q.add(index);
		v[index] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < n; i++) {
				if (v[i]) {
					continue;
				}
				if (g[now][i] == 0) {
					continue;
				}
				q.add(i);
				v[i] = true;
				d[i] = d[now] + g[now][i];
				if (max < d[i]) {
					max = d[i];
					index = i;
				}
			}
		}
		System.out.println(max);
	}
}