package JavaCode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview04_06 {

    LinkedList<TreeNode> queue = new LinkedList<>();

    /**
     * Time Complexity: O(n) {@code n} is the number of nodes
     * Space Complexity: O(n)
     * @topic Successor LCCI
     * @author ArtistS
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        while(!queue.isEmpty()){
            TreeNode pollNode = queue.pollFirst();
            if( pollNode == p && !queue.isEmpty()){
                return queue.pollFirst();
            }
        }
        return null;
    }

    public TreeNode inorder(TreeNode root, TreeNode p){
        if(root == null){
            return null;
        }
        inorder(root.left, p);
        queue.add(root);
        inorder(root.right, p);
        return null;
    }
}
