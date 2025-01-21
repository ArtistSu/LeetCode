package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers Array
 * @prb https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_80 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int currIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
                nums[currIdx++] = nums[i];
            } else {
                count++;
                if (count <= 2) {
                    nums[currIdx++] = nums[i];
                }
            }
        }
        return currIdx;
    }
}