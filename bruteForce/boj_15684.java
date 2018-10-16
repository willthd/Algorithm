package practice;

import java.util.*;

// bruteForce, 변형된? 조합
// a[] 사용하지 않는다. 왜냐? if (dep == 3) 안에서 따로 처리 할 것이 없기 때문. 대신 여기선 back tracking으로 
// 체크 해야 할 것 있음
// 어려움
public class Main6 {
	static int n, m, h, g[][], ret = Integer.MAX_VALUE;
	
	public static void f(int dep, int x) {
		if (dep >= ret) {
			return;
		}
		// 아주 의미 있는 부분. dep <= 3 일 때, 만족하면 return. 그리고 한 번 저장되면 이후 실행되는 것을 막기 위한 장치로
		// 위의 if문 추가
		if (check()) {
			ret = dep;
			return;
		}
		if (dep == 3) {
			return;
		}
		for (int i = x; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (g[i][j] == 1) {
					j++;
					continue;
				}
				g[i][j] = 1;
				f(dep + 1, i);
				g[i][j] = 0;
			}
		}
	}
	
	public static boolean check() {
		for (int i = 1; i <= n; i++) {
			int pos = i;
			for (int j = 1; j <= h; j++) {
				if (g[j][pos] == 1) {
					pos++;
				} else if (g[j][pos - 1] == 1) {
					pos--;
				}
			}
			if (pos != i) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 세로 직선 개수
		n = sc.nextInt();
		// 이미 쳐진 가로수 개수
		m = sc.nextInt();
		// 가로 직선 개수
		h = sc.nextInt();
		g = new int[31][11];
		for (int i = 0; i < m; i++) {
			g[sc.nextInt()][sc.nextInt()] = 1;
		}
		f(0, 1);
		if (ret > 3) {
			System.out.println("-1");
		} else {
			System.out.println(ret);
		}
	}
}