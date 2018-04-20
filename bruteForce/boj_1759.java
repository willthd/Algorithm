package practice;

import java.util.*;

// 백준, 1759, 암호만들기
public class Main2 {
	static int n, m, cnt1, cnt2;
	static String str[];

	static void dfs(int index, int cnt, String ans) {
		if (cnt == n) {
			check(ans);
			if (cnt1 >= 1 && cnt2 >= 2) {
				System.out.println(ans);
				System.out.println(cnt1 + " " + cnt2);
			}
			return;
		}
		for (int i = index; i < m; i++) {
			dfs(i + 1, cnt + 1, ans + str[i]);
		}
	}

	static void check(String s) {
		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				cnt1++;
			} else {
				cnt2++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		str = new String[m];
		for (int i = 0; i < m; i++) {
			str[i] = sc.next();
		}
		Arrays.sort(str);
		dfs(0, 0, "");
	}
}
