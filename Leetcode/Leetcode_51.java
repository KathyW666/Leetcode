import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_51 {
    // 八皇后问题 AC
    // 用array储存结果（方便自己检查使用)），discussion 中简化方法即直接助力成为string形式
    public List<List<String>> solveNQueens(int n) {
        Integer[] colNum = new Integer[n];
        char[][] chess = new char[n][n];
        refreshChess(chess);
        Arrays.fill(colNum, -2);
        List<List<String>> res = new ArrayList<>();
        dfs(res, colNum, 0, chess);
        return res;
    }

    private void dfs(List<List<String>> res, Integer[] colNum, int row, char[][] chess) {
        if (row == colNum.length) {
            List<String> ans = new ArrayList<>();
            for (int rr = 0; rr < row; rr++) {
                chess[rr][colNum[rr]] = 'Q';
                ans.add(String.valueOf(chess[rr]));
            }
            res.add(ans);
            refreshChess(chess);
            return;
        }
        for (int i = 0; i < colNum.length; i++) {
            if (row != 0) {
                if (!help(colNum, i, row)) continue;
            }
            colNum[row] = i;
            dfs(res, colNum, row + 1, chess);
        }
        colNum[row] = -2;
        if (row != 0) colNum[row - 1] = -2;
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

    private void refreshChess(char[][] chess) {
        for (int chessR = 0; chessR < chess.length; chessR++) {
            for (int chessL = 0; chessL < chess[0].length; chessL++)
                chess[chessR][chessL] = '.';
        }
    }

    public static void main(String[] args) {
        Leetcode_51 o = new Leetcode_51();
        List<List<String>> res = o.solveNQueens(5);
        System.out.println(res);
    }
}
