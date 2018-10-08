package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 1;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i + " " + n / i);
			}
		}
		
//		input
//		100
		
//		output
//		2 50
//		4 25
//		5 20
//		10 10
	}
}