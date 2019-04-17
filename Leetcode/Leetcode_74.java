public class Leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1])
                return binarySearch(matrix[i], target);
            else if (target < matrix[i][0]) return false;
        }
        return false;
    }

    public boolean binarySearch(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > target) hi = mid - 1;
            else if (a[mid] < target) lo = mid + 1;
            else return true;
        }
        return false;


    }

}
