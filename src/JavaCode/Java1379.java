package JavaCode;

import JavaCook.TreeNode;

public class Java1379 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes in original tree
     * Space Complexity: O(n)
     * @methor recursion
     * @topic Find a Corresponding Node of a Binary Tree in a Clone of That Tree
     * @author ArtistS
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return inorder(original, cloned, target);
    }

    public TreeNode inorder(TreeNode root1, TreeNode root2, TreeNode target){
        if(root1 == null){
            return null;
        }
        if(root1.val == target.val){
            res = root2;
        }
        inorder(root1.left, root2.left, target);
        inorder(root1.right, root2.right, target);
        return res;
    }
}
