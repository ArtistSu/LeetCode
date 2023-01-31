package JavaCode;

import java.util.Arrays;

public class Java869 {
    /**
     * Time Complexity: O(m!) {@param m} is how many digits does it has in decimal
     * Space Complexity: O(m)
     * @topic  Reordered Power of 2
     * @author ArtistS
     * @method BackTrack
     */
    boolean[] visit;

    public boolean reorderedPowerOf2(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        Arrays.sort(chars);
        visit = new boolean[chars.length];
        return traceBack(chars, 0, 0);
    }

    public boolean traceBack(char[] nums, int idx, int num) {
        if (idx == nums.length) {
            return judgePower2(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if ((num == 0 && nums[i] == '0') || visit[i] || (i > 0 && !visit[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            visit[i] = true;
            if (traceBack(nums, idx+1, num * 10 + nums[i] - '0')) {
                return true;
            }
            visit[i] = false;
        }
        return false;
    }

    public boolean judgePower2(int n) {
        return (n & (n - 1)) == 0;
    }
}
