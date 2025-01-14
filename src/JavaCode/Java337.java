package JavaCode;

import JavaCook.TreeNode;

public class Java337 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@params root}
     * Space Complexity: O(n)
     * @topic House Robber III
     * @author ArtistS
     * @method DP
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] leftChilds = dfs(root.left);
        int[] rightChilds = dfs(root.right);
        int selected = root.val + leftChilds[1] + rightChilds[1];
        int nonSelected = Math.max(leftChilds[0],leftChilds[1])+Math.max(rightChilds[0], rightChilds[1]);
        return new int[]{selected, nonSelected};
    }
}
