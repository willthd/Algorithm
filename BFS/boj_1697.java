package practice;

import java.util.*;

// 백준, 1697, 숨바꼭질
public class Main7 {
	static int n, k, dist[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		dist = new int[100001];
		Arrays.fill(dist, -1);
		dist[n] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.poll();
			int next[] = {now - 1, now + 1, now * 2};
			for (int i = 0; i < 3; i++) {
				if (next[i] < 0 ||  next[i] > 100000) {
					continue;
				}
				if (dist[next[i]] != -1) {
					continue;
				}
				dist[next[i]] = dist[now] + 1;
				q.add(next[i]);
			}
		}
		System.out.println(dist[k]);
	}
}
