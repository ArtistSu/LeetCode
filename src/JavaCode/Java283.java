package JavaCode;

public class Java283 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic: Move Zeros
     * @author: ArtistS
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int start = 0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                nums[start]=nums[i];
                if(start != i){
                    nums[i]=0;
                }
                start++;
            }

        }
    }

    /**
     * @param nums
     * @title : Move Zeroes
     * Traversal
     * @Time Complexity : O(n)
     * @Space Complexity : 0(1)
     */
    public void moveZeroes2(int[] nums) {

        int numZero = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZero++;
            }
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }
        for (int i = nums.length - 1; i >= nums.length - numZero; i--) {
            nums[i] = 0;
        }
    }

    public void moveZeroes(int[] nums) {

        // This solution aims to use in-place technique, without
        // create a new Array.
        int writePointer = 0;

        // Iterate through the nums.length indexes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                // Change the value of the nums[writePointer] amd nums[i]
                nums[writePointer] = nums[i];

                if (i != writePointer) {
                    nums[i] = 0;
                }

                writePointer++;
            }
        }
    }
}
