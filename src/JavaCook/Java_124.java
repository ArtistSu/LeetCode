package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_124 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H) H is the height of the tree
     */
    private int res = Integer.MIN_VALUE;

    public int maxPathSum_google_l4(TreeNode root) {
        maxGain(root);
        return res;
    }

    public int maxGain(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        int sum = root.val + left + right;

        res = Math.max(res, sum);
        return root.val + Math.max(left, right);
    }
}