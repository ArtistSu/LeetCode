package JavaCode;

public class Java1022 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes in {@param root}
     * Space Complexity: O(n)
     * @method dfs
     * @topic Sum of Root To Leaf Binary Numbers
     * @author ArtistS
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        return findLeaf(root, 0);
    }

    public int findLeaf(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        val = (val << 1) | root.val;
        if(root.left == null && root.right == null){
            return val;
        }
        return findLeaf(root.left,val)+findLeaf(root.right, val);
    }
}
