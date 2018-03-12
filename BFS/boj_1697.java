package practice;
import java.util.*;

// 백준, 1697, 숨바꼭질
// 스타트링크와 비슷
class Main {
	static int d[] = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		Arrays.fill(d, -1);
		d[N] = 0;

		while(!q.isEmpty()) {
			int cur = q.poll();
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < 3; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (d[next[i]] == -1) {
						d[next[i]] = d[cur] + 1;
						q.add(next[i]);
					}
				}
			}
		}
		System.out.println(d[K]);
	}
}
