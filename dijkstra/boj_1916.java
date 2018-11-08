package practice;

import java.util.*;

public class Main {
	public static int n, e, st, g[][], d[], end;
	public static boolean v[];

	public static void dijk(int st) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		d[st] = 0;
		pq.add(new Element(st, 0));
		while(!pq.isEmpty()) {
			Element now = pq.poll();
			int here = now.desti;
			v[here] = true;
			for (int i = 1; i <= n; i++) {
				if (v[i]) {
					continue;
				}
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
		v = new boolean[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(g[i], -1);
		}
		e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (g[a][b] != -1) {
				g[a][b] = Math.min(g[a][b], c);
			} else {
				g[a][b] = c;				
			}
		}
		st = sc.nextInt();
		end = sc.nextInt();
		dijk(st);
		System.out.println(d[end]);
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
