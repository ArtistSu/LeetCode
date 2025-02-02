package JavaCook;

/**
 * @author ArtistS
 * @tag Array
 * @prb https://leetcode.com/problems/special-array-i/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_3151 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;
    }
}