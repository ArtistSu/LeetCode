package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag InorderTraversal Recursion
 * @prb https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_94 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}