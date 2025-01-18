package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag PreorderTraversal
 * @prb https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * Time complexity: O(n) n is the number of nodes
 * Space complexity: O(h) h is the height of the tree
 */
public class Java_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}