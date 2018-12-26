
import java.util.HashSet;
import java.util.Set;

public class Leetcode_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            Set listR = new HashSet();
            Set listC = new HashSet();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    if (listR.contains(board[i][j])) return false;
                    else listR.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (listC.contains(board[j][i])) return false;
                    else listC.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set list3 = new HashSet();
                int k = 0;
                while (k < 3) {
                    int l = 0;
                    while (l < 3) {
                        if (board[i + k][j + l] != '.') {
                            if (list3.contains(board[i + k][j + l])) return false;
                            else list3.add(board[i + k][j + l]);
                        }
                        l++;
                    }
                    k++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_36 o = new Leetcode_36();
        char[][] board = new char[][]{{'5', '3', '1', '2', '7', '4', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(o.isValidSudoku(board));
    }
}

