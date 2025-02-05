package JavaCook;

/**
 * @author ArtistS
 * @tag Array Math TwoPointers
 * @prb https://leetcode.com/problems/rotate-array/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] nums_cp = nums.clone();
        for (int i = 0; i < k; i++) {
            nums[k - 1 - i] = nums_cp[nums.length - 1 - i];
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = nums_cp[i - k];
        }
    }
}