package JavaCode;

import java.util.LinkedList;

public class Java965 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes in the forest
     * Space Complexity: O(n)
     * @method: BFS
     * @topic: Univalued Binary Tree
     * @author: ArtistS
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;
        while(!queue.isEmpty()){
            TreeNode pollNode = queue.poll();
            if(pollNode.val != val){
                return false;
            }
            if(pollNode.left != null){
                queue.add(pollNode.left);
            }
            if(pollNode.right != null){
                queue.add(pollNode.right);
            }
        }
        return true;
    }
}
