package practice;
import java.util.*;

// 백준, 12851, 숨바꼭질2
// 숨바꼭질1과 다르게 visited[] 추가했다. 꼭 필요하지 않지만 이런 형태를 기억하는 것이 좋을 것 같다
class Main2 {
	public static final int MAX = 100001;
	static int dist[] = new int[MAX];
	static int count[] = new int[MAX];
	static boolean visited[] = new boolean[MAX];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;
		count[N] = 1;

		while(!q.isEmpty()) {
			int cur = q.poll();
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < next.length; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (!visited[next[i]]) {
						dist[next[i]] = dist[cur] + 1;
						count[next[i]] = count[cur];
						visited[next[i]] = true;
						q.add(next[i]);
					} else if (dist[next[i]] == dist[cur] + 1) {
						count[next[i]] += count[cur];
//						count[next[i]]++; or count[next[i] = count[cur] + 1 안되는 이유는?
//						정확히 안되는 테스트 케이스 못찾겠는데, 최대한 이전 기준으로 증감을 표시하는 것이 좋을 것 같다
					}
				}
			}
		}
		System.out.println(dist[K]);
		System.out.println(count[K]);
	}
}
