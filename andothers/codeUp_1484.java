package practice;

import java.util.*;

// codeUp, 1484, 2차원 배열 달팽이
public class Main {
	public static void main(String[] args) {
		// ds, dy는 어떤 방향 순서로 갈 것인지에 대한 정의
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		int arr[][];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n][m];
		// x, y 어디서 시작할 것인지
		int x = 0;
		int y = 0;
		int dir = 0;
		for (int i = 0; i < n * m; i++) {
			arr[x][y] = i + 1;
			// 그 다음 좌표가 범위를 벗어나거나, 0이 아닌수 (이미 값이 들어 있는 상태)를 만났을 때
			if (x + dx[dir] < 0 || x + dx[dir] >= n || y + dy[dir] < 0 || y + dy[dir] >= m
					|| arr[x + dx[dir]][y + dy[dir]] != 0) {
				dir++;
			}
			dir %= 4;
			x += dx[dir];
			y += dy[dir];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
