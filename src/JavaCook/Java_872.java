package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Tree DFS
 * @prb https://leetcode.com/problems/leaf-similar-trees/submissions/2134207009/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(N_1 + N_2)
 * @SpaceComplexity O(L_1 + L_2)
 * <p>
 * Interview Phase 1: Clarify & Propose the Approach (Before Coding)
 * "To check if two trees are leaf-similar, we need to
 * compare their leaf sequences from left to right.The straightforward approach is to do a full DFS traversal on both
 * trees, collect all leaf values into two separate lists, and then compare the lists. That takes $O(N_1 + N_2)$ time
 * and $O(L_1 + L_2)$ space, where $L$ is the number of leaves.However, if the trees are very large and their first few
 * leaves don't match, doing a full traversal upfront wastes both time and memory. To optimize this, I can use a lazy
 * iterator approach using a stack. This allows us to find leaves on-demand and perform an early exit as soon as a
 * mismatch is found, reducing our best-case space and time complexity to $O(H_1 + H_2)$, where $H$ is the tree
 * height."
 * <p>
 * Phase 2: Explain the Key Implementation Detail (While Writing Code)
 * "Notice that in the iterative DFS, I am pushing
 * the right child first, then the left child onto the stack. Since a stack is Last-In, First-Out (LIFO), pushing the
 * left child last guarantees that it will be popped and processed first. This preserves the strict left-to-right
 * traversal order."
 * <p>
 * Phase 3: Complexity & Trade-off Analysis (After Coding)
 */
public class Java_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> root1Leaves = new Stack<>();
        Stack<TreeNode> root2Leaves = new Stack<>();

        getLeafNode(root1Leaves, root1);
        getLeafNode(root2Leaves, root2);

        while (!root1Leaves.isEmpty() && !root2Leaves.isEmpty()) {
            if (root1Leaves.pop().val != root2Leaves.pop().val) return false;
        }

        return root1Leaves.isEmpty() && root2Leaves.isEmpty();
    }

    public void getLeafNode(Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) stack.push(root);
        getLeafNode(stack, root.left);
        getLeafNode(stack, root.right);
    }

    /**
     * Google L4 Improvement
     */
    public boolean leafSimilar_Google_L4(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }

    /**
     * Google L5 Improvement
     */
    public boolean leafSimilar_Google_L5(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (getNextLeaf(stack1) != getNextLeaf(stack2)) return false;
        }

        return stack1.isEmpty() && stack2.isEmpty();

    }

    public int getNextLeaf(Deque<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            if (curr.left == null && curr.right == null) return curr.val;
        }
        return -1;
    }

}