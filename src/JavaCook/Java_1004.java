package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch SlidingWindow PrefixSum LC75
 * @prb <a href="https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_1004 {
    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0, start = 0, end = 0, count = 0;

        while (end < nums.length) {
            if (nums[end] == 1) {
                count++;
            } else {
                if (k > 0) {
                    count++;
                    k--;
                } else {
                    maxOnes = Math.max(maxOnes, count);
                    while (nums[start++] != 0) {
                        count--;
                    }
                }
            }
            end++;
        }
        maxOnes = Math.max(maxOnes, count);
        return maxOnes;
    }

    public int longestOnesV2(int[] nums, int k) {
        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}