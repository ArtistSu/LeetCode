package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch Counting
 * @prb https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2529 {
    public int maximumCount(int[] nums) {
        int neg = 0, zero = 0;
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;

        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num == 0) {
                zero++;
            } else {
                break;
            }
        }

        return Math.max(neg, nums.length - zero - neg);
    }
}