package JavaCode;

import JavaCook.TreeNode;

import java.util.LinkedList;

public class Java1302 {

    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@params root}
     * Space Complexity: O(n)
     * @topic Deepest Leaves Sum
     * @author ArtistS
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size(), res = root.val;
        while(!queue.isEmpty()){
            res = 0;
            for(int i = 0; i < size; i++){
                TreeNode pollNode = queue.pollFirst();
                res += pollNode.val;
                if(pollNode.left != null){
                    queue.add(pollNode.left);
                }
                if(pollNode.right != null){
                    queue.add(pollNode.right);
                }
            }
            size = queue.size();
        }
        return res;
    }
}
