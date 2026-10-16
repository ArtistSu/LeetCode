package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_42{
    /**
     * @TimeComplexity O(N) N is the length of height
     * @SpaceComplexity O(N)
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            leftMax[i] = Math.max(left,height[i]);
            rightMax[n-1-i] = Math.max(right,height[n-1-i]);

            left = leftMax[i];
            right = rightMax[n-1-i];
        }


        int res = 0;
        for(int i = 1; i < n - 1; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    /**
     * @TimeComplexity O(N) N is the length of height
     * @SpaceComplexity O(1)
     */
    public int trap_google_l4(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1], left = 0, right = n-1, res = 0;

        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax > rightMax){
                res += rightMax - height[right];
                right--;
            }else{
                res += leftMax - height[left];
                left++;
            }
        }
        return res;
    }
}