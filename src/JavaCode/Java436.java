package JavaCode;

public class Java436 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param intervals}
     * Space Complexity: O(n)
     * @method BF
     * @topic Find Right Interval
     * @author ArtistS
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int value = Integer.MAX_VALUE;
            int index = -1;
            if (intervals[i][0] == intervals[i][1]) {
                res[i] = i;
                continue;
            }
            for (int j = 0; j < intervals.length; j++) {
                if (i != j && intervals[j][0] >= intervals[i][1]) {
                    if (intervals[j][0] < value) {
                        value = intervals[j][0];
                        index = j;
                    }
                }
            }
            res[i] = index;
        }
        return res;
    }
}
