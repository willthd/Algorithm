import java.util.*;

// codeUp, 1476, 2차원 배열 빗금 채우기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int var = 1;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n + m - 1; i++) {
			for (int j = 0; j < m; j++) {
				if (n > (i - j) && (i - j) >= 0) {
					arr[i - j][j] = var++;
					
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