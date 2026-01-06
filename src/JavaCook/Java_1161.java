package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag Tree DFS BFS BinaryTree
 * @prb https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
 * Time complexity: O(n) n is the number of nodes in the binary tree
 * Space complexity: O(m) m is the maximum number of nodes in one level
 */
public class Java_1161 {
    public int maxLevelSum(TreeNode root) {
        int currLevel = 0;
        int maxSum = root.val;
        int maxLevel = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int currSum = 0;
            currLevel++;
            for(int i = 0; i < queue.size(); i++){
                TreeNode currNode = queue.pop();
                if(currNode.left != null){
                    queue.addLast(currNode.left);
                }

                if(currNode.right != null){
                    queue.addLast(currNode.right);
                }
                currSum += currNode.val;
            }

            if(currSum > maxSum){
                maxSum = currSum;
                maxLevel = currLevel;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode treeNodeA = new TreeNode(1);
        TreeNode treeNodeB = new TreeNode(7);
        TreeNode treeNodeC = new TreeNode(0);
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;

        TreeNode treeNodeD = new TreeNode(7);
        TreeNode treeNodeE = new TreeNode(-8);
        treeNodeB.left = treeNodeD;
        treeNodeB.right = treeNodeE;
        int ans = new Java_1161().maxLevelSum(treeNodeA);
        System.out.println("The max level is " + ans);
    }
}
