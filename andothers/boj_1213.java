package practice;

import java.util.*;

public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int arr[] = new int[26]; 
		int length = s.length();
		for (int i = 0; i < length; i++) {
			arr[s.charAt(i) - 65]++; 
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				cnt++;
			}
		}
		char result[] = new char[length];
		if (cnt > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			int index = 0;
			for (int i = 0; i < 26; i++) {
				while(arr[i] > 1) {
					arr[i] -= 2;
					result[index] = (char) (i + 65);
					result[length - 1 - index] = (char)(i + 65);
					index++;
				}
			}			
			for (int i = 0; i < 26; i++) {
				if (arr[i] == 1) {
					result[length / 2] = (char) (i + 65);
				}
			}
			for (int i = 0; i < length; i++) {
				System.out.print(result[i]);
			}
		}
	}
}
