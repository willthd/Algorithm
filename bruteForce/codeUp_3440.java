import java.util.*;

// codeUp, 3440, 이진수 순열
public class Main {
	static int n, k, chk;
	static void print(int cnt, String ans) {
		if (cnt == n) {
			check(ans);
			if (chk == k) {
				System.out.print(ans + " ");
			}
			return;
		}
		print(cnt + 1, ans + "0");
		print(cnt + 1, ans + "1");
	}

	static void check(String ans) {
		chk = 0;
		for (int i = 0; i < ans.length(); i++) {
			if (ans.charAt(i) == '1') {
				chk++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		print(0, "");
	}
}
