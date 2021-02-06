package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2020/12/30 11:23 上午
 * Description:
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
                continue;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}




