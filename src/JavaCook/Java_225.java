package JavaCook;

import java.util.LinkedList;

/**
 * @author ArtistS
 * @tag Design Queue Stack
 * @prb https://leetcode.com/problems/implement-stack-using-queues/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_225 {
}

class MyStack {

    LinkedList<Integer> queue = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        return queue.pollLast();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}