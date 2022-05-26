package JavaCode;

public class Java238 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic Product of Array Except Self
     * @author ArtistS
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int right = nums[nums.length - 1];
        for(int i = nums.length - 2; i >=0; i--){
            res[i] = res[i] * right;
            right = nums[i] * right;
        }
        return res;
    }
}
