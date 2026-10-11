package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_274 {
    /**
     * @TimeComplexity O(N * log ( N))
     * @SpaceComplexity O(log ( N))
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = n - mid;
            if (citations[mid] >= count) {
                right = mid - 1;
            } else if (citations[mid] < count) {
                left = mid + 1;
            }
        }
        return citations[left];
    }
}