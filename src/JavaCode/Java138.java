package JavaCode;


import java.util.HashMap;
import java.util.List;

public class Java138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Time Complexity : O(n)  Space Complexity: O(n)
    public Node copyRandomList(Node head) {

        Node headCopy = head;
        Node result = new Node(-1);
        Node ans = result;
        HashMap nodeAndRandom = new HashMap<Node, Node>();
        while(head!=null)
        {
            result.next = new Node(head.val);
            result = result.next;
            nodeAndRandom.put(head, result);
            head = head.next;
        }

        head = headCopy;
        result = ans.next;
        while(head!=null)
        {
            if(head.random!=null) result.random = (Node)nodeAndRandom.get(head.random);
            result = result.next;
            head = head.next;
        }
        return ans.next;


    }



}
