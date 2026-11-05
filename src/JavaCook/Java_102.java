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
public class Java_102{
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(W) W is the width of the tree
     */
    public List<List<Integer>> levelOrder_google_l4(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelEle = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.pollFirst();
                levelEle.add(curr.val);
                if(curr.left != null){
                    queue.offerLast(curr.left);
                }
                if(curr.right != null){
                    queue.offerLast(curr.right);
                }
            }
            res.add(levelEle);
        }

        return res;
    }
}