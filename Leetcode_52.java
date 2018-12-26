import java.util.Arrays;


public class Leetcode_52 {
    public int totalNQueens(int n) {
        // 八皇后问题 只返回结果的个数 AC
        Integer[] colNum = new Integer[n];
        Arrays.fill(colNum, -2);
        return dfs(0, colNum, 0);
    }

    private int dfs(int res, Integer[] colNum, int row) {
        if (row == colNum.length) return ++res;
        for (int i = 0; i < colNum.length; i++) {
            if (row != 0) {
                if (!help(colNum, i, row)) continue;
            }
            colNum[row] = i;
            res = dfs(res, colNum, row + 1);
        }
        colNum[row] = -2;
        if (row != 0) colNum[row - 1] = -2;
        return res;
    }

    private boolean help(Integer[] colNum, int i, int row) {
        int count = 0;
        for (int a : colNum) {
            if (a < 0) break;
            if (i == a || (Math.abs(i - a) == Math.abs(row - count))) return false;
            count++;
        }
        return true;
    }

    /**
     * 方法2：用3个boolean数组储存
     * @param args
     *
     * solution{
     *  int count = 0;
        public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0,  cols, d1, d2, n);
        return count;
        }

        public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
            if(row == n) count++;

            for(int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;
                if(cols[col] || d1[id1] || d2[id2]) continue;

                cols[col] = true; d1[id1] = true; d2[id2] = true;
                backtracking(row + 1, cols, d1, d2, n);
                cols[col] = false; d1[id1] = false; d2[id2] = false;
            }
        }
     */

    public static void main(String[] args) {
        Leetcode_52 o = new Leetcode_52();
        System.out.println(o.totalNQueens(5));
    }
}
