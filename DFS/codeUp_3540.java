package practice;

import java.util.*;

// codeUp, 3540, 0만들기 게임
public class Solution {
	static  int n;
	static String val[], branch[];

	static void func(int dep) {
		if (dep == n - 1) {
			int cnt = 1;
			String s = "";
			for (int i = 0; i < n; i++) {
				if (i < n - 1) {
					s += cnt++ + "" + branch[i];					
				} else {
					s += cnt++;					
				}
			}
			if (check(s)) {
				System.out.println(s);
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			branch[dep] = val[i];
			func(dep + 1);
		}
	}
	
	static boolean check(String s) {
		String tempS = "";
		for (int i = 0; i < s.length(); i++) {
			tempS += s.charAt(i) + "";
		}
		tempS = s.replace(" ", "");
		Queue<Integer> num = new LinkedList<>();
		Queue<String> notNum = new LinkedList<>();
		String str = "";
		for (int i = 0; i < tempS.length(); i++) {
			String k = tempS.charAt(i) + "";
			int temp = 0;
			if (isNum(k)) {
				str += k;
				if (i == tempS.length() - 1) {
					temp = Integer.parseInt(str);
					num.add(temp);
				}
			} else {
				temp = Integer.parseInt(str);
				num.add(temp);
				notNum.add(k);
				str = "";
			}
		}
		int sum = num.poll();
		while (!num.isEmpty()) {
			if (notNum.poll().equals("+")) {
				sum += num.poll();
			} else {
				sum -= num.poll();
			}
		}
		if (sum == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		branch = new String[n];
		val = new String[3];
		val[0] = " ";
		val[1] = "+";
		val[2] = "-";
		func(0);
	}
}