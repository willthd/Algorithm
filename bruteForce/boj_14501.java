import java.util.*;

public class Main {
	static int n, day[], income[], result = Integer.MIN_VALUE;
	
	public static void f(int curr_sum, int curr_day) {
		if (curr_day == n) {
			result = Math.max(curr_sum, result);
			return;
		}
		int next_day = curr_day + day[curr_day];
		int next_sum = curr_sum + income[curr_day];
		if (next_day <= n) {
			f(next_sum, next_day);
		}
		if (curr_day + 1 <= n) {
			f(curr_sum, curr_day + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		day = new int[n];
		income = new int[n];
		for (int i = 0; i < n; i++) {
			day[i] = sc.nextInt();
			income[i] = sc.nextInt();
		}
		f(0, 0);
		System.out.println(result);
	}
}