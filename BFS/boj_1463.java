
package practice;

import java.util.*;

// 백준, 1463, 1로 만들기(bfs)
public class pp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dist[] = new int[1000001];
		boolean visited[] = new boolean[1000001];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if (now <= 0) {
				continue;
			}
			if (now % 3 == 0 && !visited[now / 3]) {
				int next = now / 3;
				q.add(next);
				visited[next] = true;
				dist[next] = dist[now] + 1;
			}
			if (now % 2 == 0 && !visited[now / 2]) {
				int next = now / 2;
				q.add(next);
				visited[next] = true;
				dist[next] = dist[now] + 1;
			}
			if (!visited[now - 1]) {
				int next = now - 1;
				q.add(next);
				visited[next] = true;
				dist[next] = dist[now] + 1;				
			}
		}
		System.out.println(dist[1]);
	}
}