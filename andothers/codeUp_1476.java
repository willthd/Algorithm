import java.util.*;

// codeUp, 1476, 2차원 배열 빗금 채우기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int var = 1;
		int[][] arr = new int[n][m];

		// 2중 for문
		for (int i = 0; i < n + m - 1; i++) {
			for (int j = 0; j < m; j++) {
				if (n > (i - j) && (i - j) >= 0) {
					arr[i - j][j] = var++;

				}
			}
		}

		// 3중 for문
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (j + k == i) {
						arr2[k][j] = cnt++;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
