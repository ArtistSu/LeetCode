package JavaCook;

/**
 * @author ArtistS
 * @tag Array DP SlidingWindow
 * @prb <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_1493 {
    public int longestSubarray(int[] nums) {
        int delTime = 1, start = 0, end = 0, longest = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else if (nums[end] == 0 && delTime > 0) {
                delTime--;
                end++;
            } else {
                longest = Math.max(longest, end - start - 1);
                while (delTime == 0) {
                    if (nums[start++] == 0) {
                        delTime++;
                    }
                }
            }
        }
        return Math.max(longest, end - start - 1);
    }
}