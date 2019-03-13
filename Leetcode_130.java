import java.util.HashSet;
import java.util.Set;

public class Leetcode_130 {
    /**
     * AC dfs, 简化的方案，从边缘开始检测，如此内部的O不受未检测的影响
     * 省去HashSet的使用
     */
    private boolean[][] marked;
    private int[][] id;
    private int m, n, count = 1;
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) return;
        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        id = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j] && board[i][j] == 'O') {
                    myDfs(board, i, j);
                    count++;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (id[i][j] > 0) {
                    if (i == 0 || j == 0 || i == m-1 || j == n-1)
                        set.add(id[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (id[i][j] > 0 && !set.contains(id[i][j])) board[i][j] = 'X';
            }
        }
    }

    private void myDfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > m-1 || j > n-1) return;
        if (marked[i][j] || board[i][j] == 'X') return;
        marked[i][j] = true;
        id[i][j] = count;
        myDfs(board, i+1, j);
        myDfs(board, i-1, j);
        myDfs(board, i, j+1);
        myDfs(board, i, j-1);
    }

    private boolean[][] change;

    public void answer(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) return;
        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        change = new boolean[m][n];

        // 从边缘入手
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!marked[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > m-1 || j > n-1 || marked[i][j] || board[i][j] == 'X')
            return;
        marked[i][j] = true;
        change[i][j] = true;
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    // 测试代码
    public static void main(String[] args) {
        Leetcode_130 o = new Leetcode_130();
        char[][] board = new char[][]{{'O', 'O', 'O'},
                                      {'O', 'O', 'O'},
                                      {'O', 'O', 'O'}};
        o.solve(board);
        for (char[] b : board) {
            for (char c : b)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
