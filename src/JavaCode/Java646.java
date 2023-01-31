package JavaCode;

import java.util.*;

public class Java646 {
    public static void main(String[] args) {
        new Java646().findLongestChain(new int[][]{{1, 3}, {2, 4}, {2, 6}, {8, 10}, {15, 18}, {8, 18}});
    }

    /**
     * Time Complexity: O(nlogn) {@param n} is the length of {@param pairs}
     * Space Complexity: O(1)
     * @topic  Maximum Length of Pair Chain
     * @author ArtistS
     * @method Greedy
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        int res = 0, curr = Integer.MIN_VALUE;
        Arrays.sort(pairs, (pairA, pairB) -> pairA[1] - pairB[1]);
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                res++;
            }
        }
        return res;
    }
}
