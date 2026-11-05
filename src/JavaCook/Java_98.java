package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_98{
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H) H is the height of the tree
     */
    private Integer prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val <= prev) return false;

            prev = root.val;
            root = root.right;
        }

        return true;
    }

    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H) H is the height of the tree
     */
    public boolean isValidBST_google_l4(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST_google_l4(root)){
            return false;
        }

        if(root.val <= prev) return false;

        return isValidBST_google_l4(root.right);
    }
}