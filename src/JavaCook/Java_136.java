package JavaCook;

/**
 * @author ArtistS
 * @tag Xor
 * @prb https://leetcode.com/problems/single-number/description/ Time complexity: O(n) Space complexity: O(1)
 */
public class Java_136 {
    /**
     * Time complexity: O(N) N is the length of Array nums
     * Space complexity: O(1)
     */
    public int singleNumber_google_l4(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}