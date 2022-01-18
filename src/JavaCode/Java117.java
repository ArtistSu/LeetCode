package JavaCode;

import java.util.LinkedList;
import java.util.Queue;

public class Java117 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node element = queue.poll();

                if(element.left != null){
                    queue.add(element.left);
                }
                if(element.right != null){
                    queue.add(element.right);
                }
                if(i < size - 1){
                    element.next = queue.peek();
                }
            }
        }
        return root;
    }
}
