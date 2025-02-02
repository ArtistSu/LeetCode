package JavaCook;

/**
 * @author ArtistS
 * @tag Array BruteForce
 * @prb https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1752 {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }
}