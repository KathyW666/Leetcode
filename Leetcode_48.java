import java.util.Arrays;

// AC
public class Leetcode_48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int side = matrix.length;
        for (int i = 0; i < side; i++) {
            if (side - 2 * i <= 1) break;
            for (int j = i; j < side - i - 1; j++) {
                int count = 0;
                alter(matrix, i, j, matrix[i][j], count);
            }
        }
    }

    private void alter(int[][] matrix, int i, int j, int target, int count) {
        if (count == 4) return;
        int temp = matrix[j][matrix.length - 1 - i];
        matrix[j][matrix.length - 1 - i] = target;
        alter(matrix, j, matrix.length - 1 - i, temp, count + 1);
    }

    public static void main(String[] args) {
        Leetcode_48 o = new Leetcode_48();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        o.rotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
    }
}
