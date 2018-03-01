package practice;
import java.util.*;

// 숨바꼭질3
class Main2 {
	public static final int MAX = 100001;
	static int dist[] = new int[MAX];
	static boolean visited[] = new boolean[MAX];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < next.length; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (!visited[next[i]]) {
						if(next[i] == cur * 2) {
							dist[next[i]] = dist[cur];
							visited[next[i]] = true;
						} else {
							dist[next[i]] = dist[cur] + 1;
							visited[next[i]] = true;							
						}
						q.add(next[i]);
					}
				}
			}
		}
		System.out.println(dist[K]);
	}
}