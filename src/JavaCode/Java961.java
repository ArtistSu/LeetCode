package JavaCode;

import java.util.Arrays;

public class Java961 {
    /**
     * Time Complexity: O(nlogn) {@code n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic N-Repeated Element in Size 2N Array
     * @author ArtistS
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
