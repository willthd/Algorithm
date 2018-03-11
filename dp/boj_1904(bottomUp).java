package practice;

import java.util.Scanner;

// 백준, 1904, 01타일, bottomUp
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int input = Integer.parseInt(temp);

		int[] inputs = new int[input + 1];
		inputs[0] = 1;
		inputs[1] = 1;
		for (int i = 2; i <= input; i++) {
			inputs[i] = (inputs[i - 1] + inputs[i - 2]) % 15746;
		}
		System.out.println(inputs[input]);
	}
}
