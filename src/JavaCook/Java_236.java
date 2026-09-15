package JavaCook;

/**
 * @author ArtistS
 * @tag DFS TreeNode
 * @prb https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(N)
 * @SpaceComplexity O(H) = O(logN), H is the height of the tree which is H = logN
 */
public class Java_236 {
    /**
     * Google L4 or L5 you should clear explain why the time complexity is O(N), Space complexity is O(logN)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right =lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }


}