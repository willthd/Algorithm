package practice;

import java.util.Arrays;
import java.util.Scanner;


// 1로 만들기
public class Solution {
	static int[] inputs = new int[1000000 + 1];

	public static int boj1463(int input) {
		if (inputs[input] != -1) {
			return inputs[input];
		}
		if (input == 1) {
			return 0;
		}
		int result = boj1463(input - 1) + 1;
		if (input % 2 == 0) {
			result = Math.min(result, boj1463(input / 2) + 1);
		}
		if (input % 3 == 0) {
			result = Math.min(result, boj1463(input / 3) + 1);
		}
		inputs[input] = result;
		return inputs[input];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int input = Integer.parseInt(temp);
		Arrays.fill(inputs, -1);
		System.out.println(boj1463(input));
	}
}
