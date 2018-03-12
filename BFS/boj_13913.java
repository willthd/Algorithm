package practice;

import java.util.*;

// 백준, 13913, 숨바꼭질4
class Main2 {
	public static final int MAX = 100001;
	static int dist[] = new int[MAX];
	static boolean visited[] = new boolean[MAX];
	static int before[] = new int[MAX];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < next.length; i++) {
				if (0 <= next[i] && next[i] < 100001) {
					if (!visited[next[i]]) {
						dist[next[i]] = dist[cur] + 1;
						visited[next[i]] = true;
						before[next[i]] = cur;		//이전 기록을 현재가 저장하고 있다!!
						q.add(next[i]);
					}
				}
			}
			if (visited[K]) {
				break;
			}
		}
		System.out.println(dist[K]);
		Stack<Integer> stk = new Stack<>();
		while(N != K) {
			stk.push(K);
			K = before[K];
		}
		stk.push(N);
//		이렇게 하면 안되는데 그 이유는?
//		String s = " ";
//		while(!stk.isEmpty()) {
//			s += stk.pop() + " ";
//		}
//		System.out.println(s);

//		방법1, 가장 성능 좋다
		StringBuilder sb = new StringBuilder();
		while(!stk.isEmpty()) {
			sb.append(stk.pop() + " ");
		}
		System.out.println(sb);

//		방법2, sysout("string")역시 객체를 만들고 출력한다
		while(!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
	}


}
