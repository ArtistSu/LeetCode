package JavaCode;

public class Java1480 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @method prefix sum
     * @topic Running Sum of 1d Array
     * @author ArtistS
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i]+ nums[i-1];
        }
        return nums;
    }
}
