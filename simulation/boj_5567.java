package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean arr[] = new boolean[n];
        int m = sc.nextInt();
		int aa[] = new int[m];
		int bb[] = new int[m];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			aa[i] = a;
			int b = sc.nextInt();
			bb[i] = b;
			if (a == 1) {
				arr[b - 1] = true;
				q.add(b);
			}
		}
		int k = q.size();
		for (int i = 0; i < k; i++) {
			int a = q.poll();
			for (int j = 0; j < m; j++) {
				if (a == aa[j]) {
					if (bb[j] != 1) {
						arr[bb[j] - 1] = true;						
					}
				}
				if (a == bb[j]) {
					if (aa[j] != 1) {
						arr[aa[j] - 1] = true;						
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}