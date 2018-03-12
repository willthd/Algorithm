package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준, 5014, 스타트링크
public class Main {
	static int[] d = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int full = sc.nextInt();
		int now = sc.nextInt();
		int target = sc.nextInt();
		int up = sc.nextInt();
		int down = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		q.add(now);				//enQueue
		Arrays.fill(d, -1);		// -1로 초기화시킨다
		d[now] = 0;				// 시작점

		while(!q.isEmpty()) {
			int current = q.poll();		//deQueue
			int[] canFloors = {current + up, current - down};
			for (int i = 0; i < canFloors.length; i++) {		// 새로운 노드만큼 for문 돈다
				if (canFloors[i] >= 0 && canFloors[i] <= full) {
					if (d[canFloors[i]] == -1) {
						q.add(canFloors[i]);			//enQueue
						d[canFloors[i]] = d[current] + 1;
					}
				}
			}
		}
		if (d[target] == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(d[target]);
		}
	}
}
