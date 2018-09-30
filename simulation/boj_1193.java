package practice;
import java.util.*;

// 백준, 1193, 분수찾기 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int up = 0;
		int down = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (i % 2 == 1) {
					up = i - j;
					down = j + 1;
				} else {
					up = j + 1;
					down = i - j;
				}
				++cnt;
				if (cnt == n) {
					break;
				}
			}
			if (cnt == n) {
				break;
			}
		}
		System.out.println(up + "/" + down);
	}
}