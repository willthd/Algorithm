package practice;

import java.util.*;

// SWEA, 2115, 벌꿀채취
public class pp {
	static int MAXN = 10;
	static int MAXM = 7;
	static int g[][] = new int[MAXN][MAXN];
	//벌통의 최대 수익 정보
	static int p[][] = new int[MAXN][MAXN];
	static int n, m, c;
	
	// (y, x)를 가장 왼쪽 좌표로 두는 벌통에서의 최대 수익 구하기
	static int getPSum(int mm, int y, int x, int sum, int psum) {
		// 탐색한 경우의 수익을 저장하는 변수
		if (mm == m) {
			return psum;
		}
		// 최대 수익을 저장하는 변수
		int nextSum;
		int max = 0;
		for (int i = mm; i < m; i++) {
			// C 값을 넘지 않는 범위라면 (y, x +i) 위치의 용기를 채취해볼 수 있다
			if (sum + g[y][x + i] <= c) {
				// (y, x + i) 위치의 용기를 채취할 때 수익을탐색해본다
				nextSum = getPSum(i + 1, y, x, sum + g[y][x + i], psum + g[y][x + i] * g[y][x + i]);
				// 최대 수익 갱신 가능한 경우 갱신
				if (max < nextSum) {
					max = nextSum;
				}
			}
			// (y, x + i) 위치의 용기를 채취하지 않는 경우 수익을 탐색해본다
			nextSum = getPSum(i + 1, y, x, sum, psum);
			// 최대 수익 갱신 가능한 경우 갱신
			if (max < nextSum) {
				max = nextSum;
			}
		}
		// 최대 수익 반환
		return max;
	}
	
	// (y, x)를 가장 왼쪽 좌표로 두는 벌통과 동시에 선택가능한 벌통 중 최대 수익을 내는 벌통의 최대 수익 구하기
	static int getMaxPair(int y, int x) {
		int maxR = 0;
		// 일단 같은 행에서 가로로 동시에 선택가능한 벌통 중 최대 수익 찾기
		for (int j = x + m; j <= n - m; j++) {
			if (maxR < p[y][j]) {
				maxR = p[y][j];
			}
		}
		// 다른 행에 있는 벌통은 무조건 동시에 선택가능하므로 수익값을 다 확인해본다
		for (int i = y + 1; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				if (maxR < p[i][j]) {
					maxR = p[i][j];
				}				
			}
		}
		return maxR;
	}
	
	static int solve() {
		// 동시에 선택가능한 두 벌통의 수익 합을 저장할 변수
		int sum;
		// 최대 수익값
		int ans = 0;
		
		// 모든 세로, 가로 좌표에 대해 수행한다
		for (int i = 0; i < n; i++) {
			// 단, (i, j)를 포함하여 가로로 M개의 용기가 자동선택되는 것이므로,
			// 실제 선택할 수 있는 경우의 수는 N - M + 1가지다.(M은 반드시 N 이하)
			for (int j = 0; j <= n - m; j++) {
				p[i][j] = getPSum(0, i, j, 0, 0);
			}
		}
		
		// 모든 세로, 가로 좌표에 대해 동시에 선택가능한 두 벌통의 수익 합이 최대인 경우를 찾는다
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				sum = p[i][j] + getMaxPair(i, j);
				if (ans < sum) {
					ans = sum;
				}
			}
		}
		// 최대 수익
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + solve());
		}
	}
}
