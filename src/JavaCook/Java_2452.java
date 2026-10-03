package JavaCook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_2452 {
    public long maxScore_google_l4(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        if (nums1 == null || nums2 == null || nums1.length != nums2.length) {
            return 0;
        }

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long res = Long.MIN_VALUE;
        long currSum = 0L;


        for (int[] pair : pairs) {
            int num1 = pair[0];
            int num2Min = pair[1];

            minHeap.offer(num1);
            currSum += num1;

            if (minHeap.size() > k) {
                currSum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                res = Math.max(res, currSum * num2Min);
            }
        }
        return res;
    }
}