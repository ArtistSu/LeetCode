package JavaCode;

import JavaCook.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class Java144 {
    /**
     * The order is root -> left child -> right child
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @method recursion
     * @topic Binary Tree Pre-order Traversal
     * @author ArtistS
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


}
