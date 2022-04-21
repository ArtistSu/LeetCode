package JavaCode;

import java.util.*;

public class Java448 {
    public static void main(String[] args) {
        Java448 j = new Java448();
        j.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Find All Numbers Disappeared in the Array
     * @author ArtistS
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for(int num : nums){
            int temp = Math.abs(num);
            if(nums[temp-1]>0){
                nums[temp-1] = -nums[temp-1];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
}
