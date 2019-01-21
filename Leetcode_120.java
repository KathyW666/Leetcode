import java.util.ArrayList;
import java.util.List;

/**
 * AC 三角list求到底部的最小之和
 * dp 自上而下 时间O(n^2/2) 空间O(n^2)
 */
public class Leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (j == 0) dp[i][j] += dp[i-1][j];
                else if (j == i) dp[i][j] += dp[i-1][j-1];
                else dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        return findMin(dp[n-1]);
    }

    private int findMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++)
            min = a[i] < min ? a[i] : min;
        return min;
    }

    /**
     * 法2：自下而上的dp 时间不变，空间O(n)
     * @param triangle
     * @return
     */
    public int opt(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        Leetcode_120 o = new Leetcode_120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> con1 = new ArrayList<>();
        List<Integer> con2 = new ArrayList<>();
        List<Integer> con3 = new ArrayList<>();
        List<Integer> con4 = new ArrayList<>();
        con1.add(2);
        list.add(con1);

        con2.add(3);
        con2.add(4);
        list.add(con2);

        con3.add(6);
        con3.add(5);
        con3.add(7);
        list.add(con3);

        con4.add(4);
        con4.add(1);
        con4.add(8);
        con4.add(3);
        list.add(con4);
        System.out.println(o.opt(list));
    }
}
