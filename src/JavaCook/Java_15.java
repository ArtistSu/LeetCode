package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_15{
    /**
     * @TimeComplexity O(N^2) N is the length of array nums
     * @SpaceComplexity O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            int curr = nums[i];
            // All elements bigger than 0
            if(curr > 0) break;
            if(i >= 1 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = n-1;

            while(left < right){
                int tempSum = nums[left]+nums[right];
                if(tempSum == -curr){
                    res.add(List.of(curr,nums[left],nums[right]));
                    while(left <right && nums[left] == nums[left+1]) left++;
                    while(left <right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }else if(tempSum > -curr){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}