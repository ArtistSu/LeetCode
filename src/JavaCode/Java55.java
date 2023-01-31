package JavaCode;

public class Java55 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@nums}
     * Space Complexity: O(1)
     * @topic Jump Game
     * @author ArtistS
     * @method greedy
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int right = 0, len = nums.length - 1;

        for(int i = 0; i <= len; i++){
            if(i <= right){
                right = Math.max(right, i+nums[i]);
                if(right>=len){
                    return true;
                }
            }
        }
        return false;
    }
}
