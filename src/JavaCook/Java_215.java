package JavaCook;

import java.util.PriorityQueue;

/**
 * @author ArtistS
 * @tag BinaryHeap PriorityQueue
 * @prb
 * @TimeComplexity O(N log k) - We iterate through N elements, performing heap operations of size k which take O(log k)
 * time.
 * @SpaceComplexity O(k) - The min-heap stores at most k elements at any given time.
 */
public class Java_215 {
    public int findKthLargest_google_l4(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}