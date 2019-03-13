import java.util.LinkedList;
import java.util.List;

public class Leetcode_230 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        private List<Integer> list;
        private int K;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return Integer.MIN_VALUE;
            list = new LinkedList<>();
            K = k;
            helper(root);
            return list.get(list.size()-1);
        }

        private void helper(TreeNode head) {
            if (head == null) return;
            helper(head.left);
            if (list.size() == K) return;
            list.add(head.val);
            helper(head.right);
        }
}
