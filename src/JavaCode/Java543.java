package JavaCode;

import JavaCook.TreeNode;

public class Java543 {
    int res;

    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param root}
     * Space Complexity: O(1)
     * @topic Diameter of Binary Tree
     * @author ArtistS
     * @method DFS
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        res = 1;
        findDepth(root);
        return res-1;

    }

    public int findDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        res = Math.max(res, left+right+1);
        return Math.max(right, left)+1;
    }
}
