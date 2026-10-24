package JavaCook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_56 {
    /**
     * @TimeComplexity O(N * log ( N)) N is the length of Array intervals
     * @SpaceComplexity O(1) auxiliary space (excluding the output list)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}