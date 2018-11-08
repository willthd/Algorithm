package practice;

import java.util.*;

public class Main {
	public static int n, e, d[];
	public static ArrayList<Element> arr[];
	
	public static void dijk(int st) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		pq.add(new Element(st, 0));
		d[st] = 0;
		while(!pq.isEmpty()) {
			Element now = pq.poll();
			int here = now.desti;
			int weight = now.weight;
			for (int i = 0; i < arr[here].size(); i++) {
				Element next = arr[here].get(i);
				int to = next.desti;
				int weight2 = next.weight;
				if (d[to] < d[here] + weight2) {
					continue;
				}
				d[to] = d[here] + weight2;
				pq.add(new Element(to, d[to]));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		d = new int[n + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		int st = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			arr[from].add(new Element(to, weight));
		}
		dijk(st);
		for (int i = 1; i <= n; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(d[i]);				
			}
		}
	}
}

class Element implements Comparable<Element>{
	int desti;
	int weight;
	
	Element(int desti, int weight) {
		this.desti = desti;
		this.weight = weight;
	}

	@Override
	public int compareTo(Element o) {
		return this.weight - o.weight;
	}
}