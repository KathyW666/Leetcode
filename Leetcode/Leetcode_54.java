import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0, j = 0; i <= (row+1)/2 && j <= (row + 1) / 2; i++, j++) {
            int start = i;
            while (row - start - 1 == i && j < col - start) {
                res.add(matrix[i][j++]);
                break;
            }
            while (col - start - 1 == i && i < row - start) {
                res.add(matrix[i++][j]);
                break;
            }
            while (i < row - start) {
                while (j < col - start) {
                    res.add(matrix[i][j++]);
                    if (j >= col - start) res.remove(res.size() - 1);
                }
                res.add(matrix[i++][j-1]);
                if (i >= row - start) res.remove(res.size() - 1);
            }
            while(i > start + 1) {
                while (j > start) {
                    res.add(matrix[i-1][--j]);
                    if (j <= start) res.remove(res.size() - 1);
                }
                res.add(matrix[--i][j]);
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_54 o = new Leetcode_54();
        int[][] matrix = new int[][]{{7},{9},{6},{1}};
        System.out.println(o.spiralOrder(matrix));
    }
}
