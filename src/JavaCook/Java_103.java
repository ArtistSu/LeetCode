package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_103{
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(W) W is the width of the tree
     */
    public List<List<Integer>> zigzagLevelOrder_google_l4(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // True: left -> right  False: right -> left
        boolean isLeftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.pollFirst();
                currentLevel.add(curr.val);
                if(curr.left != null){
                    queue.offerLast(curr.left);
                }
                if(curr.right != null){
                    queue.offerLast(curr.right);
                }
            }
            if(!isLeftToRight){
                Collections.reverse(currentLevel);
            }
            isLeftToRight = !isLeftToRight;
            res.add(currentLevel);
        }

        return res;
    }
}