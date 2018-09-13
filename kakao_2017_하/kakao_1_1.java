package practice;

import java.util.*;

public class ppp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		func(arr1, arr2);
	}
	
	public static void func(int arr1[], int arr2[]) {
		String result = "";
		for (int i = 0; i < arr1.length; i++) {
			String bi1 = Integer.toBinaryString(arr1[i]);
			String bi2 = Integer.toBinaryString(arr2[i]);
			String zero1 = "";
			String zero2 = "";
			for (int j = 0; j < arr1.length - bi1.length(); j++) {
				zero1 += "0";
			}
			bi1 = zero1 + bi1;
			for (int j = 0; j < arr2.length - bi2.length(); j++) {
				zero2 += "0";
			}
			bi2 = zero2 + bi2;
			result = "";
			for (int j = 0; j < arr1.length; j++) {
				if (bi1.charAt(j) == '1' || bi2.charAt(j) == '1') {
					result += "#";
				} else {
					result += " ";
				}
			}
			System.out.println(result);
		}
	}
}