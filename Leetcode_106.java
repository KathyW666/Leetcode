public class Leetcode_106 {
    /**
     * AC 同105，根据后序序列和中序序列构造树，利用后序序列的反序，从右边构造树
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        int n = postorder.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = postorder[i];
            postorder[i] = postorder[n-1-i];
            postorder[n-1-i] = temp;
        }
        return construct(inorder, postorder, 0, n-1, 0, n-1);
    }

    private TreeNode construct(int[] in, int[] post, int sI, int eI, int sP, int eP) {
        if (sP > eP) return null;
        TreeNode root = new TreeNode(post[sP]);
        int add = find(in, post[sP], sI, eI);
        root.right = construct(in, post, eI-add+1, eI, sP+1, sP+add);
        root.left = construct(in, post, sI, eI-add-1, sP+add+1, eP);
        return root;
    }

    private int find(int[] a, int target, int s, int e) {
        int i = s;
        while(i <= e) {
            if (a[i] == target) break;
            i++;
        }
        return e - i;
    }
}
