package JavaCode;
import JavaCook.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Java106 {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    /**
     * Time Complexity: O(n) {@param n} is the length of {@param inorder}
     * Space Complexity: O(n)
     * @topic Construct Binary Tree from Inorder and Postorder Traversal
     * @author ArtistS
     * @method Recursion
     * @param inLeft
     * @param inRight
     * @return
     */
    public TreeNode helper(int inLeft, int inRight){
        if(inLeft > inRight){
            return null;
        }
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        post_idx--;
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_idx = postorder.length - 1;

        int idx = 0;
        for (Integer val :
                inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0,inorder.length - 1);
    }




}
