package JavaCode;

import java.util.Stack;

public class Java42 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param height}
     * Space Complexity: O(n)
     * @topic Trapping Rain Water
     * @author ArtistS
     * @method Stack
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int start = 0, sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int end = 0; end < height.length; end++) {
            int x = height[end];
            if(stack.isEmpty()){
                stack.push(x);
                continue;
            }

            if (x >= height[start]) {
                int total = Math.min(height[start], x) * (end - start);
                while (!stack.isEmpty()) {
                    total -= stack.pop();
                }
                sum += total;
                start = end;
            }
            stack.push(x);
        }

        int top = start;
        stack.clear();
        start = height.length-1;

        for(int SecondEnd = (height.length -1); SecondEnd >= top; SecondEnd--){
            int x = height[SecondEnd];
            if(stack.isEmpty()){
                stack.push(x);
                continue;
            }

            if (x >= height[start]) {
                int total = Math.min(height[start], x) * (start-SecondEnd);
                while (!stack.isEmpty()) {
                    total -= stack.pop();
                }
                System.out.println(total);
                sum += total;
                start = SecondEnd;
            }
            stack.push(x);
        }
        return sum;
    }
}
