package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Java905 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method two methods
     * @topic Sort Array by Parity
     * @author ArtistS
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int slow = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i]%2 == 0){
                swap(slow, i, nums);
                slow++;
            }
        }
        return nums;
    }

    public void swap(int ptrA, int ptrB, int[] nums){
        int temp = nums[ptrA];
        nums[ptrA] = nums[ptrB];
        nums[ptrB] = temp;
    }

}
