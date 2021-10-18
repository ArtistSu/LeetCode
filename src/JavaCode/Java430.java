package JavaCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Java430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node next, Node child) {
            this.val = val;
            this.next = next;
            this.child = child;
        }

        public Node() {

        }
    }


    Stack<Node> st = new Stack<>();
    public Node flatten(Node head) {
        if (head != null) {

            if (head.child != null) {
                if(head.next != null){
                    st.add(head.next);
                }
                head.child.prev = head;
                head.next = flatten(head.child);
                head.child = null;
            } else {
                if (head.next == null) {
                    if (st.size() > 0) {
                        Node temp = st.pop();
                        temp.prev = head;
                        head.next = flatten(temp);
                    } else {
                        return head;
                    }
                } else {
                    head.next.prev = head;
                    head.next = flatten(head.next);

                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node m = new Java430().new Node(12, null, null);
        Node l = new Java430().new Node(11, m, null);
        Node k = new Java430().new Node(10, null, null);
        Node j = new Java430().new Node(9, k, null);
        Node i = new Java430().new Node(8, j, l);
        Node h = new Java430().new Node(7, i, null);

        Node f = new Java430().new Node(6, null, null);
        Node e = new Java430().new Node(5, f, null);
        Node d = new Java430().new Node(4, e, null);
        Node c = new Java430().new Node(3, null, null);
        Node b = new Java430().new Node(2, null, c);
        Node a = new Java430().new Node(1, null, b);

        new Java430().flatten(a);


    }


}
