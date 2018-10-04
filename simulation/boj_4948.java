
import java.util.*;

// 백준, 4948, 베르트랑 공준
// 에라토스테네스의 체 구현 -> n까지 소수 몇개 인가
// d[n] : 1부터 n까지의 소수의 총 개수
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int d[] = new int[2 * n + 1];
			boolean checked[] = new boolean[2 * n + 1];
			int sqrt = (int) Math.sqrt(2 * n);
			for (int i = 2; i <= sqrt; i++) {
				if (checked[i]) {
					continue;
				}
				for (int j = i * i; j <= 2 * n; j += i) {
					checked[j] = true;
				}
			}
			int cnt = 0;
			for (int i = 2; i <= 2 * n; i++) {
				if (checked[i]) {
					d[i] = d[i - 1];
				} else {
					d[i] = ++cnt;
				}
			}
			System.out.println(d[2 * n] - d[n]);
		}
	}
}
