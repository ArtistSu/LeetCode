package JavaCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Java225 {


    /**
     * @topic  Implement Stack using Queues
     * @author ArtistS
     */
    Queue<Integer> stack;
    public Java225() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        int n = stack.size();
        stack.offer(x);
        for (int i = 0; i < n; i++) {
            stack.offer(stack.poll());
        }
    }

    public int pop() {
        return stack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
