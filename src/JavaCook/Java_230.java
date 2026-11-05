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
public class Java_230{
    /**
     * @TimeComplexity O(H + k) H is the height of the treee
     * @SpaceComplexity O(1)
     */
    public int kthSmallest_google_l4(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr!= null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode smallest = stack.pop();
            k--;
            if(k == 0) return smallest.val;

            curr = smallest.right;
        }

        return -1;
    }
}