package practice;

import java.util.*;

public class Main {
	public static int n, e, d[];
	public static ArrayList<Element> node[]; 

	public static void dijk(int st) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		d[st] = 0;
		pq.add(new Element(st, 0));
		while(!pq.isEmpty()) {
			int here = pq.peek().desti;
			int dist = pq.peek().weight;
			pq.poll();
			for (int i = 0; i < node[here].size(); i++) {
				int next = node[here].get(i).desti;
				int weight = node[here].get(i).weight;
				if (d[next] > d[here] + weight) {
					d[next] = d[here] + weight;
					pq.add(new Element(next, d[next]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n + 1];
		node = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			node[i] = new ArrayList<>();
		}
		Arrays.fill(d, Integer.MAX_VALUE);
		e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			node[from].add(new Element(to, weight));
		}
		int st = sc.nextInt();
		int end = sc.nextInt();
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
