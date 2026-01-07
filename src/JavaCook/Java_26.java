package JavaCook;

/**
 * @author ArtistS
 * @tag Array TwoPointers
 * @prb https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}