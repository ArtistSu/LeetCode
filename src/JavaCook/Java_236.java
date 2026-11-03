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
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H)  H is the height of the tree
     */
    public TreeNode lowestCommonAncestor_google_l4(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor_google_l4(root.left, p , q);
        TreeNode rightNode = lowestCommonAncestor_google_l4(root.right,p,q);

        if(leftNode != null && rightNode != null){
            return root;
        }
        return leftNode != null ? leftNode : rightNode;
    }

}