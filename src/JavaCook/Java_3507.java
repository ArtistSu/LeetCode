package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array HashTable LinkedList Heap(priority queue) Simulation Double-LinkedList OrderedSet
 * @prb <a href="https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/submissions/1893100315/?envType=daily-question&envId=2026-01-22">...</a>
 * @TimeComplexity O(n ^ 2)
 * @SpaceComplexity O(n)
 */
public class Java_3507 {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int step = 0;
        while (list.size() > 1) {
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                int currSum = list.get(i) + list.get(i + 1);

                if (list.get(i) > list.get(i + 1)) isAscending = false;

                if (currSum < minSum) {
                    minSum = currSum;
                    idx = i;
                }
            }

            if (isAscending) break;

            step++;
            list.set(idx, minSum);
            list.remove(idx + 1);
        }
        return step;
    }
}