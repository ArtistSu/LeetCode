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

    // "Bottom - up" Time Complexity: O(1) Space Complexity: O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        Java104.TreeNode a5 = new Java104().new TreeNode(5, null, null);
        Java104.TreeNode a4 = new Java104().new TreeNode(4, null, null);
        Java104.TreeNode a3 = new Java104().new TreeNode(3, null, a5);
        Java104.TreeNode a2 = new Java104().new TreeNode(2, a4, null);
        Java104.TreeNode a1 = new Java104().new TreeNode(1, a2, a3);
        System.out.println(new Java104().maxDepth(a1));
    }
}
