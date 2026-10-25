package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_155{
}

class MinStack_google_l4{
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack_google_l4() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}