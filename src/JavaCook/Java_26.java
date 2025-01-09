package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_26 {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}