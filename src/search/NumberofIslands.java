package search;

import java.util.Arrays;

public class NumberofIslands {
	public static int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			dfs(grid, i + 1, j);
			dfs(grid, i - 1, j);
			dfs(grid, i, j + 1);
			dfs(grid, i, j - 1);

		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, 
						  { '1', '1', '0', '0', '0' }, 
						  { '0', '0', '1', '0', '0' },
						  { '0', '0', '0', '1', '1' }, 
						  { '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));
		// dfs(grid,0,0);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

	}
}
