public class Leetcode_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target || matrix[i][matrix[0].length - 1] < target) continue;
            if (binarySearch(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else return true;
        }
        return false;
    }


}
