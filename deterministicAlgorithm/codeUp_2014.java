package practice;

// codeUp, 2014, 복면산 문제2
public class Solution {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (i * 100 + j * 10 + k - (i * 10 + j) == k * 10 + k) {
						System.out.println(i+""+j+""+k+"-"+i+""+j+"="+k+""+k);
					}
				}
			}
		}
	}
}