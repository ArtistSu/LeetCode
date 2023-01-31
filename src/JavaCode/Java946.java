package JavaCode;

import java.util.Stack;

public class Java946 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param pushed}
     * Space Complexity: O(n)
     * @topic  Validate Stack Sequences
     * @author AtrstiS
     * @method Stack Stimulate
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Time Complexity: O(n) {@param n} is the length of {@param pushed}
     * Space Complexity: O(n)
     * @topic  Validate Stack Sequences
     * @author AtrstiS
     * @method Stack Stimulate
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        int pointerA = 1, pointerB = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        while(!stack.isEmpty() || pointerA < len){
            if(stack.isEmpty() && pointerA < len){
                stack.push(pushed[pointerA++]);
                continue;
            }
            if(stack.peek() == popped[pointerB]){
                stack.pop();
                pointerB++;
            }else if(pointerA < len){
                stack.push(pushed[pointerA++]);
            }else{
                break;
            }
        }
        return stack.isEmpty();
    }
}
