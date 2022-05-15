package JavaCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Java117 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes
     * Space Complexity: O(n)
     * @topic Populating Next Right Pointers in Each Node II
     * @author ArtistS
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                Node popNode = queue.poll();
                if(popNode.left != null){
                    queue.offer(popNode.left);
                }
                if(popNode.right != null){
                    queue.offer(popNode.right);
                }
                if(i != size){
                    popNode.next = queue.peek();
                }else{
                    popNode.next = null;
                }
            }
        }
        return root;
    }
}
