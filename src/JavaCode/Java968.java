package JavaCode;

import JavaCook.TreeNode;

public class Java968 {

    /**
     * Time Complexity: O(n) {@code n} is the number of nodes in the tree
     * Space Complexity: O(1)
     * @method DP
     * @topic Binary Tree Cameras
     * @author ArtistS
     * @param root
     * @return
     */
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
