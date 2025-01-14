package JavaCook;

/**
 * @author ArtistS
 * @tag PreorderTraversal Recursion
 * @prb https://leetcode.com/problems/same-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}