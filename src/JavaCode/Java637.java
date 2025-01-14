package JavaCode;

import JavaCook.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Java637 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param root}
     * Space Complexity: O(n)
     * @topic Average of Levels in Binary Tree
     * @author ArtistS
     * @method BFS
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr  = queue.poll();
                sum += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
