package practice;

import java.util.*;

// 하노이탑
public class Main2 {
	static void hanoi(int n, char from, char by, char to){
		if(n == 1){
			move(n, from, to);
		} else{           
			hanoi(n-1, from, to, by);
			move(n, from, to);
			hanoi(n-1, by, from, to);           
		}       
	}
	
	static void move(int n, char from, char to){
		System.out.println("Disk " + n + " : " + from + " to " + to);       
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n, 'A', 'B', 'C');
	}
}


