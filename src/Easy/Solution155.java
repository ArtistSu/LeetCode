package Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/23 12:56 下午
 * Description:
 */
public class Solution155 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public Solution155() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
