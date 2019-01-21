public class Leetcode_105 {
    /**
     * AC 根据前序序列和中序序列构造树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0|| inorder.length == 0) return null;
        int n = preorder.length;
        return construct(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int sP, int eP, int sI, int eI) {
        if (sP > eP) return null;
        TreeNode root = new TreeNode(preorder[sP]);
        int ADD = find(inorder, preorder[sP], sI, eI);
        root.left = construct(preorder, inorder, sP+1, sP+ADD, sI, sI+ADD-1);
        root.right = construct(preorder, inorder, sP+ADD+1,eP, sI+ADD+1, eI);
        return root;
    }

    private int find(int[] inorder, int target, int s, int e) {
        int i = s;
        while(i <= e) {
            if (inorder[i] == target) break;
            i++;
        }
        return i-s;
    }
}
