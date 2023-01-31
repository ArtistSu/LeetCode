package JavaCode;

import java.util.Stack;

public class Java1475 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param prices}
     * Space Complexity: O(n)
     *
     * @param prices
     * @return
     * @topic
     * @author ArtistS
     * @method Monotonic stack
     */
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);

        }
        return res;
    }

    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param prices}
     * Space Complexity: O(1)
     *
     * @param prices
     * @return
     * @topic
     * @author ArtistS
     * @method Stimulate
     */
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            res[i] = prices[i] - discount;
        }
        return res;
    }
}
