package JavaCode;

import java.util.LinkedList;
import java.util.List;

public class Java143 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity: O(1)
     * @topic Reorder List
     * @author ArtistS
     * @method reverse list + merge list + find middle list
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        ListNode l1_temp;
        ListNode l2_temp;
        while(l1 != null && l2 != null){
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;
            l2.next = l1;
            l2 = l2_temp;
        }
    }

    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity: O(n)
     * @topic Reorder List
     * @author ArtistS
     * @method ArrayList
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        ListNode headNode = new ListNode(0);
        ListNode currNode = headNode;

        for(int i = 0; i < list.size() / 2; i++){
            currNode.next = list.get(i);
            currNode = currNode.next;
            currNode.next = list.get(list.size() - 1 - i);
            currNode = currNode.next;
        }
        System.out.println(list.size());
        if(list.size() % 2 != 0){
            currNode.next = list.get(list.size()/2);
            currNode = currNode.next;
        }
        currNode.next = null;
    }
}
