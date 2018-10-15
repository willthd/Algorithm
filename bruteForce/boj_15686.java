import java.util.*;

// bruteForce, 조합
public class Main {
	static int n, m, total = 0, result = Integer.MAX_VALUE;
	static List<Node> per, chi;
	static int a[];

	public static void f(int st, int dep) {
		if (dep == m) {
			total = 0;
			for (int i = 0; i < per.size(); i++) {
				int min_dist = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					int dist = getDist(per.get(i), chi.get(a[j]));
					min_dist = Math.min(dist, min_dist);
				}
				total += min_dist;
			}
			result = Math.min(result, total);
			return;
		}
		for (int i = st; i < chi.size(); i++) {
			a[dep] = i;
			f(i + 1, dep + 1);
		}
	}

	public static int getDist(Node per, Node chi) {
		return (int) (Math.abs(per.x - chi.x) + Math.abs(per.y - chi.y));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		per = new LinkedList<>();
		chi = new LinkedList<>();
		a = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = sc.nextInt();
				if (a == 2) {
					chi.add(new Node(i, j));
				} else if (a == 1) {
					per.add(new Node(i, j));
				}
			}
		}
		f(0, 0);
		System.out.println(result);
	}
}

class Node {
	int x;
	int y;

	Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
