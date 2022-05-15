package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Java94 {
/**
 * The order is left child -> root -> right child
 */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @method recursion
     * @topic Binary Tree Inorder Traversal
     * @author ArtistS
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;

    }

    public void inorder(TreeNode root, List res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
