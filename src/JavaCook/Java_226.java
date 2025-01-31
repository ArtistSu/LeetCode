package JavaCook;

/**
 * @author ArtistS
 * @tag Tree DFS BFS BinaryTree
 * @prb https://leetcode.com/problems/invert-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempNode);
        return root;
    }
}