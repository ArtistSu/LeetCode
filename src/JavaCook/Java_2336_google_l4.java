package JavaCook;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity O(K) k represents the number of elements currently in the heap that were added back and have not yet been popped
 */
public class Java_2336_google_l4{
    private int cur;
    private final Set<Integer> isPresent;
    private final PriorityQueue<Integer> minHeap;

    public Java_2336_google_l4() {
        this.cur = 1;
        this.isPresent = new HashSet<>();
        this.minHeap = new PriorityQueue<>();
    }

    // Time Complexity O(logK)
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            isPresent.remove(smallest);
            return smallest;
        }
        return cur++;
    }

    // Time Complexity O(logK)
    public void addBack(int num) {
        if (num < cur && isPresent.add(num)) {
            minHeap.offer(num);
        }
    }
}