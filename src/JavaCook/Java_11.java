package JavaCook;

/**
 * @author ArtistS
 * @tag Array TwoPointers Greedy LC75
 * @prb <a href="https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(1)
 */
public class Java_11 {
    /**
     * @TimeComplexity: O(N) N is the length of array height
     * @SpaceComplexity: O(1)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int left = 0, right = n-1;
        int res = 0;

        while(left < right){
            res = Math.max(res, Math.min(height[left],height[right]) * (right - left));

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }

        return res;
    }
}