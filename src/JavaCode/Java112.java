package JavaCode;

public class Java112 {
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

    // Time Complexity:O(1) Space Complexity: O(1)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {

            if (targetSum == root.val) {
                return true;
            }
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    public static void main(String[] args) {
        TreeNode t3 = new Java112().new TreeNode(3, null, null);
        TreeNode t2 = new Java112().new TreeNode(2, null, null);
        TreeNode t1 = new Java112().new TreeNode(1, t2, t3);
        System.out.println(new Java112().hasPathSum(t1,5));

    }
}
