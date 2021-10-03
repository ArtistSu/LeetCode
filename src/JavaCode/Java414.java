package JavaCode;

public class Java414 {

    // Use bubble sort Time Complexity: O(N^2) Space Complexity: O(N)
    public int thirdMax(int[] nums) {
        int firstMaximum = nums[0];

        // sort the nums
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1] ;
                    nums[j+1] = temp;
                }
            }
        }

        // distinction
        int[] resultArr = new int[nums.length];
        int writePoint = 0;
        for (int i = nums.length - 1 ; i > 0 ; i--) {
            if(nums[i] != nums[i -1]){
                resultArr[writePoint]  = nums[i];
                writePoint++;
            }
        }
        resultArr[writePoint] = nums[0];

        // Notice writePoint is index
        if(writePoint >= 2){
            return resultArr[2];
        }
        return resultArr[0];
    }
}
