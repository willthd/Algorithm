import java.util.*;

// codeUp, 2608, 동아리 회장 선거
// 중복 순열
public class Main {
	static int n;
	static void print(int cnt, String ans) {
		if (cnt == n) {
			System.out.println(ans);
			return;
		}
		print(cnt + 1, ans + "O");
		print(cnt + 1, ans + "X");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		print(0, "");
	}
}
