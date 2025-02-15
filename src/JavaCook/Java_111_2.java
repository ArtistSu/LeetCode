package JavaCook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag Recursion BFS
 * @prb https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_111_2{
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}