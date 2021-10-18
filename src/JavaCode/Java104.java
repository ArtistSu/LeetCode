package JavaCode;

public class Java104 {
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }

    }

    int leftDepth = 0;
    int rightDepth = 0;
    // "Top - down" Time Complexity: O(n) Space Complexity: O(n)
    public int maxDepth(TreeNode root) {

        // If the node is leaf node, return 0;
        if (root == null) {
            return 0;
        }


        return Math.max(leftDepth,rightDepth);
    }
}
