## Dijkstra
</br>

edge에 값이 있는 경우, 최소 or 최대 경로 구하기

PriorityQueue를 사용하는 경우와 그렇지 않은 경우 있다.

* 사용 o, 시간복잡도 : O(ElogV)
* 사용 x, 시간복잡도 : O(V^2 + E)

따라서 PriorityQueue를 사용하는 경우가 더 빠르다. 

BFS랑 비슷. 다만 Queue대신 PriorityQueue를 사용한다. 그리고 또 다른 점은 v[] 필요없다(BFS에선 Queue에 add()할 때 v[] = true했음)

인접 배열을 사용하거나 ArrayList를 사용한다. node 개수가 많은면 인점 배열 사용할 때 메모리 초과 나는 경우 있다

</br>

</br>

### 구현

* PriorityQueue를 사용해 dijkstra구현 code(인접배열)

```java
// n : node 개수
// e : edge 개수

import java.util.*;

public class Main {
	public static int n, e, g[][], d[];

	public static void dijk(int st) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		d[st] = 0;
		pq.add(new Element(st, 0));
//      v[st] = true;
		while(!pq.isEmpty()) {
			int here = pq.poll().desti;
//          v[here] = true;
			for (int i = 1; i <= n; i++) {
//              if (v[i]) {
//                  continue;
//              }
				if (g[here][i] == -1) {
					continue;
				}
				if (d[i] <= d[here] + g[here][i]) {
					continue;
				}
				d[i] = d[here] + g[here][i];
				pq.add(new Element(i, d[i]));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n + 1][n + 1];
		d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(g[i], -1);
		}
		e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
            // from에서 to로 가는 방법이 여러개 있을 수 있다
            // 문제에 따라 달라질 수 있다
			if (g[from][to] != -1) {
				g[from][to] = Math.min(g[from][to], weight);
			} else {
				g[from][to] = weight;				
			}
            // g[to][from] = weight
            // 안하는 이유는 뒤로 다시 back안하기 때문
            // 문제에 따라 달라질 수 있다
		}
		int st = sc.nextInt();
		dijk(st);
        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + " ");
        }
	}
}

class Element implements Comparable<Element> {
	int desti;
	int weight;

	public Element(int hear, int weight) {
		this.desti = hear;
		this.weight = weight;
	}

	@Override
	public int compareTo(Element o) {
		return this.weight - o.weight;
	}
}
```

