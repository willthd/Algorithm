package practice;

import java.util.Scanner;

// 내려가기. 1149문제와 비슷
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[][] grid = new int[input + 1][3 + 1];
		for (int i = 1; i <= input; i++) {
			for (int j = 1; j <= 3; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int[][] dpMax = new int[input + 1][3 + 1];
		int[][] dpMin = new int[input + 1][3 + 1];
		for (int i = 1; i <= input; i++) {
			dpMax[i][1] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + grid[i][1];
			dpMax[i][2] = Math.max(dpMax[i - 1][3], Math.max(dpMax[i - 1][1], dpMax[i - 1][2])) + grid[i][2];
			dpMax[i][3] = Math.max(dpMax[i - 1][2], dpMax[i - 1][3]) + grid[i][3];

			dpMin[i][1] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + grid[i][1];
			dpMin[i][2] = Math.min(dpMin[i - 1][3], Math.min(dpMin[i - 1][1], dpMin[i - 1][2])) + grid[i][2];
			dpMin[i][3] = Math.min(dpMin[i - 1][2], dpMin[i - 1][3]) + grid[i][3];
		}

		int max = Math.max(Math.max(dpMax[input][1], dpMax[input][2]), dpMax[input][3]);
		int min = Math.min(Math.min(dpMin[input][1], dpMin[input][2]), dpMin[input][3]);
		System.out.println(max + " " + min);
	}
}
