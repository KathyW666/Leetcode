public class Leetcode_108 {
    /**
     * AC 有序数组转BST
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int s, int e) {
        if (s > e) return null;
        int m = s + (e-s)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, s, m-1);
        root.right = build(nums, m+1, e);
        return root;
    }
}
