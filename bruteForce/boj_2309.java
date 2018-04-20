package practice;
import java.util.*;

// 백준, 2309, 일곱난쟁이
// DFS로 풀었다
public class Main2 {
	static int sum, arr[];
	static boolean visited[];
	
	static void dfs(int index, int cnt) {
		if (cnt == 7) {
			sum = 0;
			for (int i = 0; i < 9; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (sum == 100) {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 9; i++) {
					if (visited[i]) {
						list.add(arr[i]);
					}
				}
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			return;
		}
		for (int i = index; i < 9; i++) {
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		visited = new boolean[9];
		for (int i = 0; i < 9; i ++) {
			arr[i] = sc.nextInt();
		}
		dfs(0, 0);
	}
}