package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_57 {
    /**
     * @TimeComplexity O(N) N is the length of Array intervals
     * @SpaceComplexity O(1) auxiliary space (excluding the output list)
     */
    public int[][] insert_google_l4(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Put the left side of newInterval into the result
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i += 1;
        }

        // Merge
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        // Put the right side of newInterval into the result
        while (i < n) {
            res.add(intervals[i]);
            i += 1;
        }

        return res.toArray(new int[res.size()][]);
    }
}