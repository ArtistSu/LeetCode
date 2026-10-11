package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_238{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        // Remember to consider [0,0]
        if(nums == null || nums.length < 2) return new int[0];
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = suffix[i] * prefix[i];
        }

        return ans;
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int[] productExceptSelf_google_l4(int[] nums) {
        // Remember to consider [0,0]
        if(nums == null || nums.length < 2) return null;
        int n = nums.length;

        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix = 1;
        for(int i = n-1; i >= 0; i--){
            ans[i] = suffix * ans[i];
            suffix = suffix * nums[i];
        }

        return ans;
    }
}