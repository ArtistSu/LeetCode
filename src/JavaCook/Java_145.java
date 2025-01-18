package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag PostorderTraversal
 * @prb https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_145{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root,res);
        return res;
    }

    public void postorderTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
    }
}