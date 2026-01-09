package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers String
 * @prb https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_283{
    // Time Complexity: O(n) Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        // 1. Define 2 pointer
        int read = 0, write =0;

        // 2. Find 1st non-zero number index
        while(write < nums.length && nums[write] != 0){
            write++;
        }

        read = write+1;
        // 3. Move zero
        while(read < nums.length && write < nums.length){
            if(nums[read] != 0 && nums[write] == 0){
                nums[write++] = nums[read];
                nums[read] = 0;
            }
            read++;
        }
    }

    public void moveZeroesV2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for(int i = lastNonZeroFoundAt - 1; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        new Java_283().moveZeroes(new int[]{0,1,0,3,12});
    }
}