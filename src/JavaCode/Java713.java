package JavaCode;

public class Java713 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method Sliding Window
     * @topic Subarray Product Less Than K
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 0){
            return 0;
        }
        int left =0, currRes = 1, ans = 0;
        for(int right = 0; right < nums.length; right++){
            currRes *= nums[right];
            while(left <= right && currRes >= k){
                currRes /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

}
