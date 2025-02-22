package JavaCook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ArtistS
 * @tag List
 * @prb https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_1028_3 {
    public TreeNode recoverFromPreorder(String traversal) {
        // List to track the last node at each depth
        List<TreeNode> levels = new ArrayList<>();
        int index = 0, n = traversal.length();

        while (index < n) {
            // Count depth (number of dashes)
            int depth = 0;
            while (index < n && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            // Extract node value
            int value = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            // Create the new node
            TreeNode node = new TreeNode(value);

            // Adjust levels list to match the current depth
            if (depth < levels.size()) {
                levels.set(depth, node);
            } else {
                levels.add(node);
            }

            // Attach the node to its parent
            if (depth > 0) {
                TreeNode parent = levels.get(depth - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }

        // The root node is always at index 0
        return levels.get(0);
    }

    public static void main(String[] args) {
        new Java_1028_3().recoverFromPreorder("1-2--3--4-5--6--7");
    }

}