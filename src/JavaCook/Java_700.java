package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(N)
 * @SpaceComplexity O(W) W is the width of the tree
 */
public class Java_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.val == val) return node;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return null;
    }

    public TreeNode searchBST_google_l5(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return root.val > val ? searchBST_google_l5(root.left, val) : searchBST_google_l5(root.right, val);
    }

    public TreeNode searchBST_google_l5_2(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}