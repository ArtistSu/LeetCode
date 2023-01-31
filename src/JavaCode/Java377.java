package JavaCode;

public class Java377 {
    /**
     * Time Complexity: O(target * n) {@param target} {@param n} is the length of {@param nums}
     * Space Complexity: O(target)
     * @topic Combination Sum IV
     * @Author ArtistS
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){

            for(int num: nums){
                if(num <= i){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
