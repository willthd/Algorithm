
public class CountCellsInBlob {
	
	private static int N = 8;
	private static int[][] grid = {
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 1, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 0, 1, 1, 0, 0},
			{0, 1, 1, 1, 0, 0, 1, 1},
			{0, 1, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 1, 0, 0}
	};
	private static int BACKGROUND_COLOUR = 0;
	private static int IMAGE_COLOUR = 1;
	private static int ALEADY_COUNTED = 2;
	
	public static void printGrid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int countCells(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return 0;
		} else if(grid[x][y] != IMAGE_COLOUR) {
			return 0;
		} else {
			grid[x][y] = ALEADY_COUNTED;
			return 1 + countCells(x - 1, y) + countCells(x - 1, y + 1) + countCells(x, y + 1)
			 + countCells(x + 1, y + 1) + countCells(x + 1, y) + countCells(x + 1, y - 1)
			 + countCells(x, y - 1) + countCells(x - 1, y - 1);
		}
	}
	
	public static void main(String[] args) {
		printGrid();
		int result = countCells(4,7);
		System.out.println(result);
	}
}
