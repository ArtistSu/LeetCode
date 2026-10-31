package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(1)
     */
    public Node connect_google_l4(Node root) {
        if (root == null) return root;

        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            Node curr = head;
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            head = dummy.next;
        }
        return root;
    }
}