package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_901{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    private static class Pair{
        private int price;
        private int consecutiveDays;

        public Pair(int price, int days){
            this.price = price;
            this.consecutiveDays = days;
        }
    }
    private final Deque<Pair> stack;

    public Java_901() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new Pair(price,1));
            return 1;
        }
        int days = 1;
        while(!stack.isEmpty() && stack.peek().price < price){
            int preDay = stack.pop().consecutiveDays;
            days += preDay;
        }
        stack.push(new Pair(price,days));
        return days;
    }
}