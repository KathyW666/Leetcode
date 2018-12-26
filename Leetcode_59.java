import java.util.Arrays;

public class Leetcode_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int layerNum = 1;
        for (int i = 0, j = 0, k = n; i < n && j < n; i++, j++, n--) {
            int start = i;
            while (j < n) res[i][j++] = layerNum++;
            j--; i++;
            while (i < n) res[i++][j] = layerNum++;
            i--; j--;
            while (j >= start) res[i][j--] = layerNum++;
            j++; i--;
            while (i > start) res[i--][j] = layerNum++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_59 o = new Leetcode_59();
        for(int[] num : o.generateMatrix(3)){
            System.out.println(Arrays.toString(num));
        }
    }
}
