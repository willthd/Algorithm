package practice;

import java.util.*;

// 백준, 1110, 더하기 사이클
public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dist[] = new int[10000000];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			String s1 = (now % 10) + "";
			String ss = ((now / 10) + (now % 10)) + "";
			String s2 = (Integer.parseInt(ss) % 10) + "";
			int next = Integer.parseInt(s1 + s2);
			if (next >= 0 && next <= 99) {
				q.add(next);
				dist[next] = dist[now] + 1;
			}
			if (next == n) {
				break;
			}
		}
		System.out.println(dist[n]);

	}
}
