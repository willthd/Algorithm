import java.util.*;

public class Main4 {
	static int n, cnt;

	static boolean check(long arr[], long i) {
		for (int j = 0; j < n - 1; j++) {
			long diff = arr[j + 1] - arr[j];
			if (diff % i != 0) {
				return false;
			}
			cnt += (diff / i - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		long min = (int) 1e9;
		for (int i = 0; i < n - 1; i++) {
			long diff = arr[i + 1] - arr[i];
			if (min > diff) {
				min = diff;
			}
		}
		int result = (int) 1e9;
		for (long i = min; i >= 1; i--) {
			cnt = 0;
			if (check(arr, i)) {
				result = Math.min(cnt, result);
			}
		}
		System.out.println(result);
	}
}
