package JavaCook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_138 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in Node head
     * @SpaceComplexity O(N)
     * Note: This approach is faster than using Map<Node, Node> directly because it avoids hash overhead.
     * Furthermore, ArrayList uses a contiguous array under the hood, which provides excellent cache locality
     * and a very high cache hit rate in the CPU's L1/L2 caches.
     */
    public Node copyRandomList_google_l4(Node head) {
        if (head == null) return null;

        Node dummyHead = new Node(0);
        Node curr = dummyHead;

        List<Node> newListNodes = new ArrayList<>();
        Map<Node, Integer> order = new HashMap<>();

        // Next
        int idx = 0;
        Node newHead = head;
        while (newHead != null) {
            Node newNode = new Node(newHead.val);
            curr.next = newNode;
            curr = curr.next;

            newListNodes.add(newNode);
            order.put(newHead, idx);

            newHead = newHead.next;
            idx++;
        }

        idx = 0;
        while (head != null) {
            if (head.random != null) {
                newListNodes.get(idx).random = newListNodes.get(order.get(head.random));
            }
            head = head.next;
            idx++;
        }

        return dummyHead.next;
    }

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
}