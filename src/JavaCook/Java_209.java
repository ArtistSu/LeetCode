package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_209{
    /**
     * @TimeComplexity O(N) N is the length of array nums
     * @SpaceComplexity O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0, right = 0, n = nums.length, res = Integer.MAX_VALUE;
        long tempSum = 0L;

        while(right < n){
            while(tempSum < target && right < n){
                tempSum += nums[right++];
            }

            while(tempSum >= target && left < right){
                res=Math.min(res,right-left);
                tempSum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * @TimeComplexity O(N) N is the length of array nums
     * @SpaceComplexity O(1)
     */
    public int minSubArrayLen_google_l4(int target, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0, n = nums.length, res = Integer.MAX_VALUE;
        long sum = 0L;

        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(sum >= target){
                res=Math.min(res,right-left+1);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}