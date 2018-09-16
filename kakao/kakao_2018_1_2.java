package practice;

import java.util.*;

// kakao 2018 하반기 1차 2번
public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 5;
		int stages[] = {1, 1, 1, 1};
		int answer[] = solution(N, stages);
	}
	
	public static int[] solution(int N, int[] stages) {
		double arr[] = new double[N + 1];
		int answer[] = new int[N];
		int total = stages.length;
		int num = 0;
		for (int i = 1; i <= N; i++) {
			total = total - num;
			num = 0;
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i) {
					num++;
				}
			}
			if (total == 0) {
				arr[i] = 0;
			} else {
				arr[i] = ((double)num / (double)total);
			}
		}
		boolean check[] = new boolean[N + 1];
		for (int j = 1; j <= N; j++) {
			double maxV = -1;
			int maxI = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i]) {
					continue;
				}
				if (maxV < arr[i]) {
					maxV = arr[i];
					maxI = i;
				}
			}
			check[maxI] = true;			
			answer[j - 1] = maxI;
		}
        return answer;
    }
}