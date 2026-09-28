package JavaCook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ArtistS
 * @tag Tree DFS BFS BinaryTree
 * @prb https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
 * Time complexity: O(n) n is the number of nodes in the binary tree
 * Space complexity: O(m) m is the maximum number of nodes in one level
 */
public class Java_1161 {
    public int maxLevelSum_google_l5(TreeNode root) {
        int maxLevel = 1;
        int currLevel = 1;
        long maxSum = Long.MIN_VALUE;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            long tempSum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode currNode = queue.pollFirst();
                tempSum += currNode.val;

                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }

        return maxLevel;
    }

    public int maxLevelSum_google_l5_2(TreeNode root) {
        List<Long> levelSums = new ArrayList<>();
        dfs(root,0,levelSums);

        int maxLevel = 1;
        long maxSum = Long.MIN_VALUE;

        for(int i = 0; i < levelSums.size(); i++){
            if(levelSums.get(i) > maxSum){
                maxSum = levelSums.get(i);
                maxLevel = i;
            }
        }

        return maxLevel+1;
    }

    private void dfs(TreeNode node, int level, List<Long> levelSums){
        if(node == null) return;

        if(levelSums.size() == level){
            levelSums.add((long)node.val);
        }else{
            levelSums.set(level,levelSums.get(level)+node.val);
        }

        if(node.left != null) dfs(node.left, level + 1, levelSums);
        if(node.right != null) dfs(node.right, level + 1, levelSums);
    }


}
