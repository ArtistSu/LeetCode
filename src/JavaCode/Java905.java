package JavaCode;

public class Java905 {
    public int[] sortArrayByParity(int[] nums) {
        int writePointer = 0;
        int temp = 0;

        // Iterate over all items in the Array
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0 ){

                // Switch the value of  nums[writePointer] and nums[i]
                // Notice: writePointer will never get ahead of the index i
                if (writePointer != i){
                    temp = nums[writePointer];
                    nums[writePointer] = nums[i];
                    nums[i] = temp;
                }
                writePointer++;
            }
        }

        return nums;
    }
}
