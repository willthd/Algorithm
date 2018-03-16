import java.util.Scanner;

// codeUp, 2625, 삼각화단
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= j; k++) {
					if (n == i + j + k) {
						if (i < j + k) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
