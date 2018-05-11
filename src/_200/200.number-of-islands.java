package _200;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visit(i, j, m, n, grid);
                }

            }
        }

        return count;
    }

    private void visit(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;

        if (grid[i][j] == '0' || grid[i][j] == '#')
            return;

        grid[i][j] = '#';
        visit(i - 1, j, m, n, grid);
        visit(i + 1, j, m, n, grid);
        visit(i, j - 1, m, n, grid);
        visit(i, j + 1, m, n, grid);
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


