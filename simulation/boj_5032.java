package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int n = sc.nextInt();
		int p = e + f;
		int cnt = 0;
		while(p/n > 0) {
			cnt += p/n;
			p = p - (n * (p/n)) + p/n;
		}
		System.out.println(cnt);
	}
}