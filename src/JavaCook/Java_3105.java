package JavaCook;

/**
 * @author ArtistS
 * @tag Array
 * @prb https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/
 * Time complexity:O(n)
 * Space complexity: O(1)
 */
public class Java_3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            res = Math.max(Math.max(res, incLen), decLen);
        }

        return res;
    }

    public static void main(String[] args) {
        new Java_3105().longestMonotonicSubarray(new int[]{3, 2, 1});
    }
}