package Easy;

import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/22 12:44 下午
 * Description:
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> nodeVisited = new HashMap<>();
        nodeVisited.put(head, head.val);
        while (head.next != null) {
            if (nodeVisited.containsKey(head.next)) {
                return true;
            }
            nodeVisited.put(head.next, head.next.val);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> nodesSet = new HashSet<>();
        while (head != null) {
            if (nodesSet.contains(head)) {
                return true;
            }
            nodesSet.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
