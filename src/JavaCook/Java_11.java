package JavaCook;

/**
 * @author ArtistS
 * @tag Array TwoPointers Greedy LC75
 * @prb <a href="https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(1)
 */
public class Java_11 {
    // TimeComplexity: O(n^2) SpaceComplexity:O(1) TimeOut
    public int maxArea(int[] height) {
        // Try to find (end-start)*Math.min(height[start],height[end]);
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        for (int start = 0; start < n; start++) {
            int end = start;
            int length = 0;
            while (end < n) {
                length = end-start;
                maxArea = Math.max(maxArea, length * Math.min(height[start], height[end]));
                end++;
            }
        }
        return maxArea;
    }

    //TimeComplexity:O(n) SpaceComplexity:O(1)
    public int maxAreaV2(int[] height) {
        // Try to find (end-start)*Math.min(height[start],height[end]);
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int start = 0, end = n-1;
        while(start < end){
            maxArea = Math.max(maxArea,(end-start) * Math.min(height[start],height[end]));
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new Java_11().maxArea(new int[]{1, 2});
    }
}