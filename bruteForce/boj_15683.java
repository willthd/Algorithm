package practice;

import java.util.*;

// bruteForce, 중복순열
public class Main4 {
	static List<Node> cctv;
	static int a[], g[][], g_copy[][], n, m, min = Integer.MAX_VALUE;

	public static void f(int dep) {
		if (dep == cctv.size()) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					g_copy[i][j] = g[i][j];
				}
			}
			for (int i = 0; i < cctv.size(); i++) {
				int val = cctv.get(i).val;
				int x = cctv.get(i).x;
				int y = cctv.get(i).y;
				if (val == 1) {
					if (a[i] == 0) {
						go0(x, y);
					}
					if (a[i] == 1) {
						go1(x, y);
					}
					if (a[i] == 2) {
						go2(x, y);
					}
					if (a[i] == 3) {
						go3(x, y);
					}
				}
				if (val == 2) {
					if (a[i] % 2 == 0) {
						go0(x, y);
						go2(x, y);
					}
					if (a[i] % 2 == 1) {
						go1(x, y);
						go3(x, y);
					}
				}
				if (val == 3) {
					if (a[i] == 0) {
						go0(x, y);
						go3(x, y);
					}
					if (a[i] == 1) {
						go0(x, y);
						go1(x, y);
					}
					if (a[i] == 2) {
						go1(x, y);
						go2(x, y);
					}
					if (a[i] == 3) {
						go2(x, y);
						go3(x, y);
					}
				}
				if (val == 4) {
					if (a[i] == 0) {
						go0(x, y);
						go1(x, y);
						go3(x, y);
					}
					if (a[i] == 1) {
						go0(x, y);
						go1(x, y);
						go2(x, y);
					}
					if (a[i] == 2) {
						go1(x, y);
						go2(x, y);
						go3(x, y);
					}
					if (a[i] == 3) {
						go0(x, y);
						go2(x, y);
						go3(x, y);
					}
				}
				if (val == 5) {
					go0(x, y);
					go1(x, y);
					go2(x, y);
					go3(x, y);
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (g_copy[i][j] == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			a[dep] = i;
			f(dep + 1);
		}
	}

	public static void go0(int x, int y) {
		for (int i = y + 1; i < m; i++) {
			if (g_copy[x][i] == 6) {
				break;
			}
			if (g_copy[x][i] == 0) {
				g_copy[x][i] = -1;
			}
		}
	}

	public static void go1(int x, int y) {
		for (int i = x + 1; i < n; i++) {
			if (g_copy[i][y] == 6) {
				break;
			}
			if (g_copy[i][y] == 0) {
				g_copy[i][y] = -1;
			}
		}
	}

	public static void go2(int x, int y) {
		for (int i = y - 1; i >= 0; i--) {
			if (g_copy[x][i] == 6) {
				break;
			}
			if (g_copy[x][i] == 0) {
				g_copy[x][i] = -1;
			}
		}
	}

	public static void go3(int x, int y) {
		for (int i = x - 1; i >= 0; i--) {
			if (g_copy[i][y] == 6) {
				break;
			}
			if (g_copy[i][y] == 0) {
				g_copy[i][y] = -1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n][m];
		g_copy = new int[n][m];
		cctv = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = sc.nextInt();
				g[i][j] = a;
				if (a != 0 && a != 6) {
					cctv.add(new Node(a, i, j));
				}
			}
		}
		a = new int[cctv.size()];
		f(0);
		System.out.println(min);
	}
}

class Node {
	int val;
	int x;
	int y;

	Node(int val, int x, int y) {
		this.val = val;
		this.x = x;
		this.y = y;
	}
}