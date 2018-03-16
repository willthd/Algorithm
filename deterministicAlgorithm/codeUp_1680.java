package practice;

// codeUp, 1680, 복면산 문제1
public class Solution {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (20 * i == j * 100) {
					System.out.println(i + "0" + "+" + i + "0" + "=" + j + "00");
				}
			}
		}
	}
}