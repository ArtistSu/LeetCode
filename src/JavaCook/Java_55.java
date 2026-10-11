package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_55{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int maxReach = 0;
        for (int i = 0; i <= maxReach && i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}