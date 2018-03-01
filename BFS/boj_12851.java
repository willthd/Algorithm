package practice;
import java.util.*;

// 숨바꼭질2
class Main2 {
	static int d[] = new int[100001];
	static int c[] = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		Arrays.fill(d, -1);
		d[N] = 0;
		c[N] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < 3; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (d[next[i]] == -1) {
						d[next[i]] = d[cur] + 1;
						c[next[i]] = c[cur];
						q.add(next[i]);
					} else if (d[next[i]] == d[cur] + 1) {
						c[next[i]] = c[cur] + 1;
//						c[next[i]]++; 안되는 이유는? 정확히 안되는 테스트 케이스 못찾겠는데,
//						최대한 이전 기준으로 증감을 표시하는 것이 좋을 것 같다
					}
				}
			}
		}
		System.out.println(d[K]);
		System.out.println(c[K]);
	}
}