package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_114 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(N)
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode curr = list.get(i);
            curr.right = list.get(i + 1);
            curr.left = null;
        }
        list.get(list.size() - 1).right = null;
    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * @TimeComplexity O(N) where N is the number of nodes in the tree
     * @SpaceComplexity O(1)
     */
    public void flatten_google_l4(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // 1. Find the rightmost node in the left subtree
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // 2. Connect the original right subtree to the right of the predecessor
                predecessor.right = curr.right;

                // 3. Move the left subtree to the right
                curr.right = curr.left;
                curr.left = null;
            }

            // 4. Move to the next node
            curr = curr.right;
        }
    }
}