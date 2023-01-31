package JavaCode;

public class Java53 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic Maximum Subarray
     * @author ArtistS
     * @method Pre-sum
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0], previous = nums[0];
        for(int i = 1; i < nums.length; i++){
            previous = Math.max(previous+nums[i], nums[i]);
            ans = Math.max(previous, ans);
        }
        return ans;
    }
}
