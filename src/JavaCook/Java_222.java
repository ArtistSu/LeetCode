package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_222 {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}