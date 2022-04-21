package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java1 {
    public static void main(String[] args) {
        Java1 j = new Java1();
        j.twoSum(new int[]{3,2,4},6);
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;

        Map<Integer, Integer> data = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            data.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            if(data.containsKey(target-nums[i]) && data.get(target-nums[i])!=i){
                result[0] = i;
                result[1] = data.get(target-nums[i]);
            }
            if(result[0] != Integer.MIN_VALUE){
                return result;
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length,1);
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;

    }
}
