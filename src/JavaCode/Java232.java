package JavaCode;

import java.util.Stack;

public class Java232 {

    /**
     * @topic Implement queue using stacks
     * @author ArtistS
     */
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front, size;

    public Java232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        size++;
    }

    public int pop() {
        int val = s1.pop();
        size--;

        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return val;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return (size == 0);
    }


}
