public class Leetcode_200 {
    /**
     * AC dfs - 联通分量
     */
    private int[] id;
    private boolean[] marked;
    private int m, n, count = 0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        marked = new boolean[m*n];
        id = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i*n+j] && grid[i][j] == '1') {
                    dfs (grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (marked[i*n+j] || grid[i][j] == '0') return;
        marked[i*n+j] = true;
        id[i*n+j] = count;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
