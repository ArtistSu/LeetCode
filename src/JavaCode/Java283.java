package JavaCode;

public class Java283 {
    public void moveZeroes(int[] nums) {

        // This solution aims to use in-place technique, without
        // create a new Array.
        int writePointer = 0;

        // Iterate through the nums.length indexes
        for (int i = 0; i < nums.length ; i++) {
            if( nums[i] != 0){

                // Change the value of the nums[writePointer] amd nums[i]
                nums[writePointer] = nums[i];

                if(i != writePointer){
                    nums[i] = 0;
                }

                writePointer++;
            }
        }
    }
}
