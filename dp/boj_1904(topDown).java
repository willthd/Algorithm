package practice;

import java.util.Arrays;
import java.util.Scanner;

// 백준, 1904, 01타일, topDown 
public class Solution {
	static int[] inputs = new int[1000000 + 1];

	public static int boj1904(int input) {
		if (inputs[input] != -1) {
			return inputs[input];
		}
		if (input == 0 || input == 1) {
			return 1;
		} else {
			inputs[input] = (boj1904(input - 1) + boj1904(input - 2)) % 15746;
		}
		return inputs[input];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int input = Integer.parseInt(temp);
		Arrays.fill(inputs, -1);
		System.out.println(boj1904(input));
	}
}
