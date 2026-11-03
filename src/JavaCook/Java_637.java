package JavaCook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_637{
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(W) W is the width of the tree
     */
    public List<Double> averageOfLevels_google_l4(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Double> res = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currSize = queue.size();
            long sum = 0;
            for(int i = 0; i < currSize;i++){
                TreeNode curr = queue.pollFirst();
                sum += curr.val;

                if(curr.left != null){
                    queue.offerLast(curr.left);
                }
                if(curr.right != null){
                    queue.offerLast(curr.right);
                }

            }

            res.add((double)sum/currSize);
        }

        return res;
    }
}