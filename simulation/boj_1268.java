package practice;
import java.util.*;
// 백준, 1268, 임시 반장 정하기
public class Solution {
	static int g[][], cnt, n;
	
	static boolean check(int arr1[], int arr2[]) {
		for (int i = 0; i < 5; i++) {
			if (arr1[i] == arr2[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		g = new int[n][5];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		int no = 0;
		for (int i = 0; i < n; i++) {
			cnt = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (check(g[i], g[j])) {
					cnt++;
				}
				if (max < cnt) {
					max = cnt;
					no = i;
				}
			}
			System.out.println(cnt);
		}
		System.out.println(no + 1);
	}
}