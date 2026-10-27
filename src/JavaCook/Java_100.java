package JavaCook;

/**
 * @author ArtistS
 * @tag PreorderTraversal Recursion
 * @prb https://leetcode.com/problems/same-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_100 {
    /**
     * Time complexity: O(N) N is the minimum number of nodes in TreeNode p and q
     * Space complexity: O(H) H is the minimum height of Tree p and q
     */
    public boolean isSameTree_google_l4(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree_google_l4(p.left,q.left) && isSameTree_google_l4(p.right,q.right);
    }
}