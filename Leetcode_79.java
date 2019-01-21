public class Leetcode_79 {
    /**
     * AC 二维char数组中查找word
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        if (board.length == 0 && board[0].length == 0) {
            if (word.length() == 0) return true;
            else return false;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWord(board, i, j, chars, 0)) return true;
            }
        }
        return false;
    }

    private boolean isWord(char[][] board, int i, int j, char[] chars, int id) {
        if (id >= chars.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] == chars[id]) {
            char temp = board[i][j];
            board[i][j] = ' ';
            // 注意：此处判断不是之后要把board[i][j]归位
            if (isWord(board, i+1, j, chars, id+1) || isWord(board, i-1, j, chars, id+1)
                    || isWord(board, i, j+1, chars, id+1) || isWord(board, i, j-1, chars, id+1))
                return true;
            else board[i][j] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode_79 o = new Leetcode_79();
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(o.exist(board, word));
    }
}
