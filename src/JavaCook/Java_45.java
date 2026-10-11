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
public class Java_45 {
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        if (nums.length == 1) return 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int steps = 1, maxIdx = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int start = queue.peek();

            for (int i = 0; i < queueSize; i++) {
                int currIdx = queue.pollFirst();
                int nextIdx = currIdx + nums[currIdx];
                maxIdx = Math.max(maxIdx, nextIdx);
                if (maxIdx >= (n - 1)) return steps;
            }

            for (int i = start + 1; i <= maxIdx; i++) {
                queue.offerLast(i);
            }
            steps++;
        }

        return -1;
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int jump_google_l4_strong(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;
        int farthest = 0, currEnd = 0, jump = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(i + nums[i], farthest);

            if (i == currEnd) {
                jump += 1;
                currEnd = farthest;

                if (farthest >= (n - 1)) break;
            }
        }
        return jump;
    }
}