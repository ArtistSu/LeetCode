package JavaCode;


import JavaCook.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Java145 {
    /**
     * The order is left child -> right child -> root
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @topic Binary Tree Post-order Traversal
     * @author ArtistS
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

}
