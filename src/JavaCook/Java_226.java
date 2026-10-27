package JavaCook;

/**
 * @author ArtistS
 * @tag Tree DFS BFS BinaryTree
 * @prb https://leetcode.com/problems/invert-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_226 {
    /**
     * Time complexity: O(N) N is the number of node in Tree root
     * Space complexity: O(H) H is the height of Tree root
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;

        return root;
    }
}