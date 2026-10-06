package JavaCook;

public class Java_198 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = 0, prev2 = 0;

        for(int i = 0; i < n; i++){
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
