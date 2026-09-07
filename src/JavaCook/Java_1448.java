package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(N_1 + N_2)
 * @SpaceComplexity O(H_1 + H_2)
 */
public class Java_1448 {

    int res;

    public int goodNodes(TreeNode root) {
        res = 0;
        findMaxValInPath(root, root.val);

        return res;
    }

    public void findMaxValInPath(TreeNode root, int maxPathVal) {
        if (root == null) return;

        int currMaxVal = Math.max(maxPathVal, root.val);
        if (maxPathVal <= root.val) res++;

        findMaxValInPath(root.left, currMaxVal);
        findMaxValInPath(root.right, currMaxVal);
    }

    /**
     * Google L4
     * In my refactored code, I eliminated the class-level result variable res and instead returned the counts
     * explicitly through the recursive call stack.
     * <p>
     * This makes the implementation stateless and thread-safe, which avoids side effects when the method is called
     * concurrently or multiple times in production environments.
     */
    public int goodNodes_google_L4(TreeNode root) {

        return findMaxValInPath_google_l4(root, root.val);

    }

    public int findMaxValInPath_google_l4(TreeNode root, int maxPathVal) {
        if (root == null) return 0;

        int currMaxVal = Math.max(maxPathVal, root.val);
        int count = 0;
        if (maxPathVal <= root.val) count++;

        count += findMaxValInPath_google_l4(root.left, currMaxVal);
        count += findMaxValInPath_google_l4(root.right, currMaxVal);

        return count;
    }

    /**
     * Google L5 - If the tree is extremely deep, recursion will cause a StackOverflowError. How would you rewrite it as iteration?
     */
    private record NodeState(TreeNode node, int maxSoFar) {}
    public int goodNodes_google_L5(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;


        Deque<NodeState> stack = new ArrayDeque<>();
        stack.push(new NodeState(root, root.val));

        while (!stack.isEmpty()) {
            NodeState nodeState = stack.pop();

            if (nodeState.maxSoFar <= nodeState.node.val ) {
                count++;
            }

            int currMaxVal = Math.max(nodeState.maxSoFar,nodeState.node.val);
            if(nodeState.node.right != null){
                stack.push(new NodeState(nodeState.node.right, currMaxVal));
            }
            if(nodeState.node.left != null){
                stack.push(new NodeState(nodeState.node.left, currMaxVal));
            }
        }

        return count;
    }



}