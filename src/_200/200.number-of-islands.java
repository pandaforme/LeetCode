package _200;

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0)
            return 0;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visit(visited, grid, i, j);
                }
            }
        }

        return count;
    }

    private void visit(boolean[][] visited, char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length)
            return;

        if (j < 0 || j >= grid[0].length)
            return;

        if (grid[i][j] != '1' || visited[i][j])
            return;

        visited[i][j] = true;

        // left
        visit(visited, grid, i, j - 1);
        // right
        visit(visited, grid, i, j + 1);
        // up
        visit(visited, grid, i - 1, j);
        // down
        visit(visited, grid, i + 1, j);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        }));
    }
}
