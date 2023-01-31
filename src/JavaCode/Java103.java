package JavaCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Java103 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @topic Binary Tree Zigzag Level Order Traversal
     * @author ArtistS
     * @method Deque
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }
        deque.add(root);
        boolean flag = true;
        while(!deque.isEmpty()){
            Deque<Integer> list = new LinkedList<>();
            int dequeSize = deque.size();
            for(int i = 0; i < dequeSize; i++){

                TreeNode currNode = deque.pollFirst();
                if(flag){
                    list.offerLast(currNode.val);
                }else{
                    list.offerFirst(currNode.val);
                }
                if(currNode.left != null){
                    deque.offerLast(currNode.left);
                }
                if(currNode.right != null){
                    deque.offerLast(currNode.right);
                }
            }
            res.add(new LinkedList<Integer>(list));
            flag = !flag;
        }
        return res;
    }
}
