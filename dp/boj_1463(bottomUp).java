package practice;

import java.util.Arrays;
import java.util.Scanner;

// 1로 만들기
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int input = Integer.parseInt(temp);
		int[] inputs = new int[input + 1];
		Arrays.fill(inputs, 1000000000);
		inputs[1] = 0;
		for (int i = 1; i < input; i++) {
			inputs[i + 1] = Math.min(inputs[i + 1], inputs[i] + 1);
			if (i * 2 < input + 1) {
				inputs[i * 2] = Math.min(inputs[i * 2], inputs[i] + 1);
			}
			if (i * 3 < input + 1) {
				inputs[i * 3] = Math.min(inputs[i * 3], inputs[i] + 1);
			}
		}
		System.out.println(inputs[input]);
	}
}
