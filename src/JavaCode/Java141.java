package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java141 {

    public boolean hasCycle(ListNode head) {

        // Record the position of cycleNode
        int position = 0;
        // Check for edge cases i.e only have 1 node
        if (head == null || head.next == null) {
            return false;
        }

        // Iterate over the list and put the node into a map
        Map<ListNode, Integer> map = new HashMap();

        while (head.next != null) {
            position++;

            if (map.containsKey(head.next)) {
                return true;
            } else {
                map.put(head.next, position);
                head = head.next;
            }
        }

        return false;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
