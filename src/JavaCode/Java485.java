package JavaCode;

public class Java485 {
    /**
     * Title: Max Consecutive Ones
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxOnes = nums[0] == 1 ? 1 : 0;
        int currOnes = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 1 && nums[i] == nums[i-1]){
                currOnes++;
            }else{
                currOnes = nums[i];
            }

            maxOnes = currOnes > maxOnes ? currOnes : maxOnes;
        }
        return maxOnes;
    }

        int[] nums = new int[6];
    public int findMaxConsecutiveOnes(int[] nums){
            int maxConsecutive = 0;
            int currConsecutive = 0;
            for (int currItem :
                    nums) {
                if (currItem == 1){
                    currConsecutive++;
                    if(currConsecutive > maxConsecutive){
                        maxConsecutive = currConsecutive;
                    }
                }
                if (currItem == 0){
                    currConsecutive = 0;
                    if(currConsecutive > maxConsecutive){
                        maxConsecutive = currConsecutive;
                    }
                }
            }
            return maxConsecutive;
        }
}
