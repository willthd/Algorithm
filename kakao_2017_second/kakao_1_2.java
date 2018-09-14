package practice;

import java.util.*;

// kakao 2017 하반기 1차 2번
public class ppp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		Stack<Integer> sta = new Stack<>();
		int num = 0;
		for (int i = 0; i < st.length(); i++) {
			if (isNum(st.substring(i, i + 1))) {
				System.out.println(num);
				sta.push(num);
				num = Integer.parseInt(st.substring(i, i + 1));
			} else {
				String ch = st.substring(i, i + 1);
				if (ch.equals("D")) {
					num = (int) Math.pow(num, 2);
				} else if (ch.equals("T")) {
					num = (int) Math.pow(num, 3);
				} else if (ch.equals("*")) {
					num = 2 * num;
					int before = sta.pop() * 2;
					sta.push(before);
				} else if (ch.equals("#")) {
					num = (-1) * num;
				}
			}
			if (i == st.length() - 1) {
				System.out.println(num);
				sta.push(num);
			}
		}
		int result = 0;
		while (!sta.isEmpty()) {
			result += sta.pop();
		}
		System.out.println("result : " + result);
	}
	
	public static boolean isNum(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}