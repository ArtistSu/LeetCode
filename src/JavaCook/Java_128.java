package JavaCook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_128 {
    /**
     * @TimeComplexity O(N * log ( N)) N is the length of Array nums.
     * @SpaceComplexity O(1)
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int res = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            res = Math.max(res, currentStreak);
        }
        return res;
    }

    /**
     * @TimeComplexity O(N) N is the length of Array nums.
     * @SpaceComplexity O(N)
     */
    public int longestConsecutive_google_l4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 1;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curr = num;
                int currentStreak = 1;
                while (numSet.contains(curr + 1)) {
                    currentStreak += 1;
                    curr += 1;
                }

                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }
}