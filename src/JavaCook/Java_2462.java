package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(k log(candidates))
 * @SpaceComplexity O(candidates)
 */
public class Java_2462 {
    public long totalCost_google_l4(int[] costs, int k, int candidates) {
        // defensive check
        if (costs == null || costs.length == 0 || k <= 0 || candidates <= 0) {
            return 0L;
        }

        int n = costs.length;
        int headCapacity = Math.min(candidates, n);

        PriorityQueue<Integer> headQueue = new PriorityQueue<>(headCapacity);
        PriorityQueue<Integer> tailQueue = new PriorityQueue<>(headCapacity);
        int left = 0, right = n - 1;
        long res = 0L;

        while (left < candidates && left < n) {
            headQueue.offer(costs[left++]);
        }

        while (tailQueue.size() < candidates && right >= left) {
            tailQueue.offer(costs[right--]);
        }

        for (int i = 0; i < k; i++) {
            // Remember to validate the priorityQueue is empty or not
            int headPeek = headQueue.isEmpty() ? Integer.MAX_VALUE : headQueue.peek();
            int tailPeek = tailQueue.isEmpty() ? Integer.MAX_VALUE : tailQueue.peek();

            if (headPeek <= tailPeek) {
                res += headQueue.poll();
                if (left <= right) {
                    headQueue.offer(costs[left++]);
                }
            } else {
                res += tailQueue.poll();
                if (left <= right) {
                    tailQueue.offer(costs[right--]);
                }
            }
        }

        return res;
    }
}