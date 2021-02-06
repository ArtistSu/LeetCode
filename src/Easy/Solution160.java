package Easy;

import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/24 11:40 上午
 * Description:第三种方法很简单, 假设AB两个链表有相同的一部分长度为小b, 那么A链表就是a+b,B链表就是c+b. 所以两边同时遍历就
 * 变成了a+b+c,和c+b+a.这样看来就很直观ac的长度可以不等,但是b是相等的(也可以为0),所以遍历的最终结果就是相交点或者b根本就不
 * 存在
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Deque<ListNode> dequeA = new LinkedList<>();
        Deque<ListNode> dequeB = new LinkedList<>();
        ListNode currNode = headA;
        while (currNode.next != null) {
            dequeA.offer(currNode);
            currNode = currNode.next;
        }
        dequeA.offer(currNode);
        currNode = headB;
        while (currNode.next != null) {
            dequeB.offer(currNode);
            currNode = currNode.next;
        }
        dequeB.offer(currNode);
        ListNode resultNode = null;
        while ((!dequeA.isEmpty()) && (!dequeB.isEmpty())) {
            ListNode tempA = dequeA.pollLast();
            ListNode tempB = dequeB.pollLast();
            if (tempA.equals(tempB)) {
                if (tempA.val == tempB.val) {
                    resultNode = new ListNode(tempA.val);
                    continue;
                }
            }
            break;
        }
        return resultNode;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //1. Literate the ListNode A
        ListNode currNode = headA;
        Map<ListNode, Integer> elementsA = new HashMap();
        while (currNode.next != null) {
            elementsA.put(currNode, currNode.val);
            currNode = currNode.next;
        }
        elementsA.put(currNode, currNode.val);
        //2. Literate the ListNode B
        currNode = headB;
        while (currNode.next != null) {
            if (elementsA.containsKey(currNode)) {
                return currNode;
            }
            currNode = currNode.next;
        }
        return elementsA.containsKey(currNode) ? currNode : null;

    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode currNodeA = headA;
        ListNode currNodeB = headB;

        boolean isASwitched = false;
        boolean isBSwitched = false;
        while(currNodeA != currNodeB){
            if(currNodeA.next == null){
                if(isASwitched){
                    return null;
                }
                currNodeA = headB;
                isASwitched = true;
            }else{
                currNodeA = currNodeA.next;
            }

            if(currNodeB.next == null){
                if(isBSwitched){
                    return null;
                }
                currNodeB = headA;
                isBSwitched = true;
            }else{
                currNodeB = currNodeB.next;
            }

        }
        return currNodeA;

    }
}