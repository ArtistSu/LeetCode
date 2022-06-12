package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java1695 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @method Slide Window
     * @topic Maximum Erasure Value
     * @author ArtistS
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0, left = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int right = 0; right < nums.length; right++){
            int curr = nums[right];
            sum+=curr;
            if(set.contains(curr)){
                while(nums[left] != curr){
                    sum-=nums[left];
                    set.remove(nums[left++]);
                }
                sum-=nums[left++];
            }else{
                set.add(curr);
                res=Math.max(sum, res);
            }
        }
        return res;
    }
}
