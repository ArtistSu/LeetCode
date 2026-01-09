package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable Tree DFS BFS BinaryTree
 * @prb https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/?envType=daily-question&envId=2026-01-09
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(n)
 */
public class Java_865 {
    Map<TreeNode, Integer> nodes;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Edge case
        if(root.left == null &  root.right == null) return root;

        // 1. Annotate the depth of each node
        nodes = new HashMap<>();
        dfs(root,0);

        // 2. Find the max depth
        for(int depth : nodes.values()){
            maxDepth = Math.max(depth, maxDepth);
        }

        // 3. Find answer
        return answer(root);
    }

    public void dfs(TreeNode node, int depth){
        if(node != null){
            nodes.put(node,depth);
            dfs(node.left,depth+1);
            dfs(node.right,depth+1);
        }
    }

    public TreeNode answer(TreeNode node){
        // 1. The depth of the node == maxDepth, the node is the answer;
        if(node == null || nodes.get(node) == maxDepth) return node;

        TreeNode left = answer(node.left);
        TreeNode right = answer(node.right);

        if(left != null && right != null) return node;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}
