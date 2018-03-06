package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 백준, 2667, 단지번호붙이기. 이 문제는 2468 안전영역 문제와 같이 grid 개수도 구해야 하는데, countCells method만으로도
// grid 개수를 구할 수 있다. 2468에선 countGrids method를 이용해 구했지만, 여기서의 countCells method만 기억해도
// 충분하다. 또 하나 주의 할 점은 입력값이 줄 단위이기 때문에, sc.nextInt()를 반복해선 제대로 입력값을 받지 않는다
// next와 nextLine의 차이를 알 필요가 있는데, next는 띄어쓰기나 줄바꿈 문자를 무시하지만, nextLine은 그렇지 않다
// 따라서 sc.nextInt() 사용 후에 nextLine()을 이용하면 nextInt()에서 쓰고 남은 줄바꿈 문자가 버퍼에 남아 있고,
// 이는 이후의 nextLine()에 영향을 준다. 따라서 아래와 같이 사용하거나, sc.nextInt()와 sc.next()만 사용하도록한다
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int n = Integer.parseInt(sc.nextLine());
	public static int[][] grid = new int[n][n];
	public static boolean[][] visited = new boolean[n][n];
	public static List<Integer> value = new ArrayList<>();

	public static int countCells(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= n) {
			return 0;
		} else if (visited[x][y] == true) {
			return 0;
		} else if (grid[x][y] == 0) {
			return 0;
		} else {
			visited[x][y] = true;
			return 1 + countCells(x - 1, y) + countCells(x + 1, y) + countCells(x, y - 1) + countCells(x, y + 1);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(sb.charAt(j) + "");
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0 && visited[i][j] == false) {
					value.add(countCells(i, j));
				}
			}
		}

		System.out.println(value.size());			
		Collections.sort(value);
		for (int i = 0; i < value.size(); i++) {
			System.out.println(value.get(i));
		}
	}
}